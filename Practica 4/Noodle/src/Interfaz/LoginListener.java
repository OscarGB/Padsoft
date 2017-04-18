package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plataforma.Plataforma;

public class LoginListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
//		if(Plataforma.login(Plataforma.profesor().getNia(), Plataforma.profesor().getPassword()) == false){
//			PanelLogin.failPasswordLabel.setVisible(true);
//		}
		
		if(Plataforma.login(PanelLogin.usrField.getText().trim(), new String(PanelLogin.pwdField.getPassword())) == false){
			PanelLogin.failPasswordLabel.setVisible(true);
		}
		else{
			PanelLogin.failPasswordLabel.setVisible(false);
		}
		System.out.println("usr: " + PanelLogin.usrField.getText().trim() + " pwd: " + new String(PanelLogin.pwdField.getPassword()));
	}
}

