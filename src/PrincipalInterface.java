import java.awt.EventQueue;

import br.com.empresa.view.TelaConsultaBiblia;

public class PrincipalInterface {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaBiblia frame = new TelaConsultaBiblia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
