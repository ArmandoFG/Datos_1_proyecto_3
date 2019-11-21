
import com.graphviewer.dao.NodoDAO;


/**
 *
 * @author arman
 */
public class lista_grafo {
    
    GrafoDAO raiz;
    
    public lista_grafo(){
        raiz = null;
    }
    
    
    public void agregar(int id, NodoDAO Nodo){
     
        GrafoDAO nuevo = new GrafoDAO(id, Nodo); 
        if (raiz == null){
            raiz = nuevo;
        } 
    }}