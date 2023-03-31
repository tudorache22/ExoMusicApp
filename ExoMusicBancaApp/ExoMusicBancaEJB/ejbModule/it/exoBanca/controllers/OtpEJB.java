package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.OtpControllerInterface;
import it.exoBanca.models.Otp;
import it.exolab.costanti.Const;

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

}
