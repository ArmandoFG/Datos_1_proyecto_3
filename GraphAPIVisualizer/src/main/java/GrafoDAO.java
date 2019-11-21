
import com.graphviewer.dao.NodoDAO;


/**
 *
 * @author arman
 */
public class GrafoDAO {
    int id;   
    NodoDAO nodo;
    GrafoDAO next;
        
                   
    
   
    public GrafoDAO(int id_grafo, NodoDAO Nodo){
        id = id_grafo;
        nodo = Nodo;
        next = null;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodoDAO getNodo() {
        return nodo;
    }

    public void setNodo(NodoDAO nodo) {
        this.nodo = nodo;
    }

    public GrafoDAO getNext() {
        return next;
    }

    public void setNext(GrafoDAO next) {
        this.next = next;
    }
    

  
    

    
     
}

