package it.exoBanca.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.OtpControllerInterface;
import it.exoBanca.models.Otp;
import it.exoBanca.models.Transazione;
import it.exolab.costanti.Const;
import it.exolab.generatoreOtp.GeneraOtp;

@Stateless(name="OtpControllerInterface")
@LocalBean
public class OtpEJB extends BaseEJB<Otp> implements OtpControllerInterface{

	@Override
	public Otp insert(Otp model) {
		// TODO Auto-generated method stub
		return super.insert(model);
	}

	@Override
	public Otp update(Otp model) {
		// TODO Auto-generated method stub
		return super.update(model);
	}

	@Override
	public void delete(Otp model) {
		// TODO Auto-generated method stub
		super.delete(model);
	}

	@Override
	public Otp findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(Otp.class, id);
	}

	@Override
	public List<Otp> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(Const.TABELLA_OTP);
	}

	@Override
	public Otp nuovoOtp(Transazione transazione) {
		try {
			Otp otp = new Otp();
			otp.setCodice(new GeneraOtp().generator());
			otp.setCreazione(Date.valueOf(LocalDate.now()));
			otp.setScadenza(Date.valueOf(LocalDate.now().plusDays(1)));
			otp.setStato(Otp.STATO_ATTIVO);
			otp.setIdTransazione(transazione.getIdTransazione());
			insert(otp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
