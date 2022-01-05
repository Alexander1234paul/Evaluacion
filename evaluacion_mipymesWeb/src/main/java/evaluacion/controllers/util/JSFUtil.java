package evaluacion.controllers.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * 
 * @author msalazar
 *
 */
public class JSFUtil {
	public static void crearMensajeInfo(String mensaje) {
		FacesMessage mFacesMessage=new FacesMessage();
		mFacesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		mFacesMessage.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, mFacesMessage);
	}
	
	public static void crearMensajeWarning(String mensaje) {
		FacesMessage mFacesMessage=new FacesMessage();
		mFacesMessage.setSeverity(FacesMessage.SEVERITY_WARN);
		mFacesMessage.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, mFacesMessage);
	}
	
	public static void crearMensajeError(String mensaje) {
		FacesMessage mFacesMessage=new FacesMessage();
		mFacesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		mFacesMessage.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, mFacesMessage);
	}
}