package it.exoBanca.controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import it.exoBanca.ejbInterfaces.OtpControllerInterface;
import it.exoBanca.models.Otp;

@Stateless(name = "OtpController")
@LocalBean
public class OtpController implements OtpControllerInterface {

	@Override
	public Otp insert(Otp model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Otp update(Otp model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Otp findById(Integer idModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Otp> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Otp model) {
		// TODO Auto-generated method stub

	}

}
