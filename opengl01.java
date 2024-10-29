package opengl01;


import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
// υποενότητα ΝΕWT είναι ένα ελαφρύ API για την δημιουργία παραθύρων
//
import com.jogamp.opengl.GLCapabilities;
/*Η GLCapabilities ένα αντικείμενο το οποίο περιγράφει τις ρυθμίσεις της γραφικής επιφάνειας 
 * (rendering surface),
 * όπως αν θα υπάρχει υποστήριξη για βάθος, ανάλυση χρώματος*/
import com.jogamp.opengl.GLContext;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
/*
 * Η GLProfile είναι μια κλάση της JOGL (Java for OpenGL) 
 * που χρησιμοποιείται για να καθορίσει και να επιλέξει την έκδοση 
 * και τον τύπο προφίλ του OpenGL που θα χρησιμοποιηθεί στην εφαρμογή.
 */
import com.jogamp.opengl.util.Animator;

/*Animator εκτελεί έναν επαναλαμβανόμενο βρόχο (loop) που καλεί την display() σε τακτά χρονικά διαστήματα. 
 * Με αυτόν τον τρόπο, μπορείτε να δημιουργήσετε 
 * κινούμενα γραφικά ή να ανανεώνετε το παράθυρο OpenGL για να προβάλλετε μεταβολές στη σκηνή.
 */


public class opengl01 {
	private static GLWindow window = null;
	private static Animator animator = null; // Animator για ανανέωση
	
	
	public static void init() {
		
		
		GLProfile.initSingleton();
		/*Αρχικοποίηση του GLProfile: Αυτή η μέθοδος είναι υπεύθυνη για την 
		αρχικοποίηση των εσωτερικών δομών που απαιτούνται 
		για την υποστήριξη του OpenGL profile management.
		Συνήθως καλείται στην αρχή του προγράμματος, πριν από οποιαδήποτε 
		δημιουργία παραθύρων OpenGL
	    ή οποιαδήποτε άλλη ενέργεια που σχετίζεται με OpenGL.*/
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		/*Η μεταβλητή GLProfile profile είναι ένα αντικείμενο της 
		κλάσης GLProfile. Αυτό το αντικείμενο χρησιμοποιείται 
		για να καθορίσει ποιο 
		προφίλ OpenGL θα χρησιμοποιηθεί στην εφαρμογή*/
	    GLCapabilities caps = new GLCapabilities(profile);
		
		/*δημιουργεί ένα αντικείμενο που καθορίζει τις ρυθμίσεις και τις 
		  δυνατότητες του OpenGL context για την εφαρμογή σας, βασισμένο 
		  στο επιλεγμένο GLProfile. Αυτό επιτρέπει την παραμετροποίηση της απόδοσης
		  γραφικών και τη ρύθμιση των χαρακτηριστικών του παραθύρου OpenGL.
		 */
		
		window  = GLWindow.create(caps);
		window.setSize(640,360);

		window.setResizable(false);
		window.setVisible(true);
		window.setTitle("My OpenGL Window");
		window.addGLEventListener(new BackgroundColorListener());
	   // Δημιουργία και εκκίνηση του animator
        animator = new Animator(window);
        animator.start();
    }
	
		
	
			
	
	public static void main(String[] args) {
		
		init();
		 // Κρατάει το πρόγραμμα ανοιχτό μέχρι να κλείσει το παράθυρο
        while (window.isVisible()) {
            // Κενός βρόχος για να συνεχίσει να λειτουργεί η εφαρμογή
        }

     // Τερματισμός του Animator όταν το παράθυρο κλείσει
        animator.stop();

	}
}
//Δημιουργία κλάσης για τον καθορισμό του background χρώματος
class BackgroundColorListener implements GLEventListener {
 @Override
 public void init(GLAutoDrawable drawable) {   // Για αρχικοποίηση γραφικων παραστάσεων
	                                          /*Η μέθοδος init χρησιμοποιείται συνήθως για να ρυθμίσεις το περιβάλλον 
	                                           * γραφικών και να εκτελέσεις οποιαδήποτε αρχικοποίηση απαιτείται για την εφαρμογή. 
	                                           * Αυτό περιλαμβάνει τη ρύθμιση των χρωμάτων, της προοπτικής, και άλλων παραμέτρων του OpenGL.
	                                           */
     
     
                                               
 }

 @Override
 public void display(GLAutoDrawable drawable) {
     GL2 gl = drawable.getGL().getGL2();      // Με το αντικείμενο GL2, μπορείς να καλέσεις πολλές μεθόδους για να διαχειριστείς τις
                                              // γραφικές παραστάσεις. Ορισμένες συνηθισμένες λειτουργίες περιλαμβάνουν:
     
     // Ορισμός του background χρώματος σε μπλε
     gl.glClearColor(0.0f, 0.0f, 1.0f, 1.0f); // Μπλε χρώμα (RGB)
     // Καθαρισμός του παραθύρου με το μπλε background χρώμα
     gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    // gl.glBegin(GL.GL_TRIANGLES); // Ένα απλό τρίγωνο
    // gl.glColor3f(1.0f, 0.0f, 0.0f); // Κόκκινο χρώμα
    // gl.glVertex3f(0.0f, 1.0f, 0.0f);
   //  gl.glVertex3f(-1.0f, -1.0f, 0.0f);
    // gl.glVertex3f(1.0f, -1.0f, 0.0f);
   //  gl.glEnd();
    // gl.glFlush(); // Εμφάνιση γραφικών
    
 }

 @Override
 public void dispose(GLAutoDrawable drawable) {
     // Δεν απαιτείται κάποια ενέργεια εδώ καθορισμός πόρων
 }

 @Override
 public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
     GL2 gl = drawable.getGL().getGL2();
     gl.glViewport(0, 0, width, height);
 }
}
