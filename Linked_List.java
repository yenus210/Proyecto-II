
package Estructuras;

import java.util.concurrent.ThreadLocalRandom;

public class Linked_List{
    
	private Dragon root;
	private int lenght = 0;
	
	public Dragon getRoot() {
		return root;
	}
	public void setRoot(Dragon root) {
		this.root = root;
	}
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public void append(Dragon dragon) {
		if(root == null) {
			root = dragon;
			root.setNext(null);
			++this.lenght;
			return;
		}
		Dragon last = root;
		while(last.getNext() != null) {
			last = last.getNext();
		}
		dragon.setNext(null);
		last.setNext(dragon);
		++this.lenght;
		return;
	}

	public void printList() {
		Dragon n = root;
		for(int i = 0 ; i<this.lenght;i++) {
			System.out.println(n.getNombre());
			n = n.getNext();
		}
	}

	public Dragon getNodeinIndex(int n){
		Dragon current = this.root;
		int counter = 0;
		while(counter != n) {
			current = current.getNext();
			++counter;
		}
		return current;
	}
        public int getEdadinIndex(int n){
		Dragon current = this.root;
		int counter = 0;
		while(counter != n) {
			current = current.getNext();
			++counter;
		}
		return current.getEdad();
	}

	public void deleteNodeinIndex(int n) {
		Dragon temp = root;
		if (lenght==1) {
			root=null;
		}
		else{
			
		if (n>=lenght) {
			throw new IllegalArgumentException("Josu");
		}
		else {
			if (n==0) {
				root = root.getNext();
				lenght = lenght-1;
			}
			else {
				if (n==lenght-1) {
					int counter=0;
					while(counter!=n-1) {
						temp= temp.getNext();
						counter+=1;
					}
					temp.setNext(null);
					lenght = lenght-1;
				}
				else {
						int counter=0;
						while(counter != n-1) {
							temp = temp.getNext();
							counter+=1;
						}
						temp.setNext(temp.getNext().getNext());
						lenght = lenght-1;
					}
				}
	
			}
		}
		}


        public void delete(Object data,Linked_List lista){
            for(int i = 0; i < lista.lenght; i++){
                if(lista.getNodeinIndex(i).getEdad()== (int)data){
                    lista.deleteNodeinIndex(i);
                }
                    
            }System.out.println("Done");
        }
        public Linked_List SelectionSortporEdadmM(Linked_List listaDragones){
        for (int i = 0; i < listaDragones.getLenght() - 1; i++){
            int index = i;
            for (int j = i + 1; j < listaDragones.getLenght(); j++)
                if (listaDragones.getNodeinIndex(j).getEdad() < listaDragones.getNodeinIndex(index).getEdad())
                    index = j;
            int smallerNumber = listaDragones.getNodeinIndex(index).getEdad();
            listaDragones.getNodeinIndex(index).setEdad(listaDragones.getNodeinIndex(i).getEdad());
            listaDragones.getNodeinIndex(i).setEdad(smallerNumber);
            
        }return listaDragones;

    }
    public void SelectionSortporEdadMm(Linked_List listaDragones){
        for (int i = 0; i < listaDragones.getLenght() - 1; i++){
            int index = i;
            for (int j = i + 1; j < listaDragones.getLenght(); j++)
                if (listaDragones.getNodeinIndex(j).getEdad() > listaDragones.getNodeinIndex(index).getEdad())
                    index = j;
            int smallerNumber = listaDragones.getNodeinIndex(index).getEdad();
            listaDragones.getNodeinIndex(index).setEdad(listaDragones.getNodeinIndex(i).getEdad());
            listaDragones.getNodeinIndex(i).setEdad(smallerNumber);
            
        }return;

    }
    
    public void InsertionSortporVelocidadRecargamM(Linked_List listaDragones){
        int temp = 0;
        for (int i = 1; i < listaDragones.getLenght(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(listaDragones.getNodeinIndex(j-1).getVelocidadRecarga() > listaDragones.getNodeinIndex(j).getVelocidadRecarga()){
                    listaDragones.getNodeinIndex(j).setVelocidadRecarga(temp);
                    listaDragones.getNodeinIndex(j).setVelocidadRecarga(listaDragones.getNodeinIndex(j-1).getVelocidadRecarga());
                    listaDragones.getNodeinIndex(j-1).setVelocidadRecarga(temp);                    
                }
            }

        }
        return;
    }
    public void InsertionSortporVelocidadRecargaMm(Linked_List listaDragones){
        int temp = 0;
        for (int i = 1; i < listaDragones.getLenght(); i++) {
            for(int j = i ; j > 0 ; j--){
                if(listaDragones.getNodeinIndex(j-1).getVelocidadRecarga() < listaDragones.getNodeinIndex(j).getVelocidadRecarga()){
                    listaDragones.getNodeinIndex(j).setVelocidadRecarga(temp);
                    listaDragones.getNodeinIndex(j).setVelocidadRecarga(listaDragones.getNodeinIndex(j-1).getVelocidadRecarga());
                    listaDragones.getNodeinIndex(j-1).setVelocidadRecarga(temp);                    
                }
            }

        }
        return;
    }
    //* elimina de la lista de dragones el dragon que murio
    public void dragondisparado(Linked_List listadragones, Dragon dragon){
        dragon.setResistencia(dragon.getResistencia()-1);
        if (dragon.getResistencia()== 0){
            listadragones.delete(dragon, listadragones);          
         }
        
    }
    int min;
    int max;
    private int getNumeroRandom(){
        this.min = 0;
        this.max = 100;
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    //*da la posicion de los dragones para graficarlos en pantalla
    public void graficoSort(Linked_List listadragones){
        int x = 100;
        int index;
        Dragon current;
        current = listadragones.getRoot();
        while(current.getNext()!= null){
            current.setPos(x,getNumeroRandom());
            current  = current.getNext();
            x = x+25;
        }
        
    }

        
}

