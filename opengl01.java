package opengl01;


import com.jogamp.newt.opengl.GLWindow;
// υποενότητα ΝΕWT είναι ένα ελαφρύ API για την δημιουργία παραθύρων
//
import com.jogamp.opengl.GLCapabilities;
/*Η GLCapabilities ένα αντικείμενο το οποίο περιγράφει τις ρυθμίσεις της γραφικής επιφάνειας 
 * (rendering surface),
 * όπως αν θα υπάρχει υποστήριξη για βάθος, ανάλυση χρώματος*/

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
