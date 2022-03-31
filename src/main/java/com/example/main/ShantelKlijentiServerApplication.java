package com.example.main;

import com.example.main.models.*;
import com.example.main.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShantelKlijentiServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ShantelKlijentiServerApplication.class, args);
	}

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	LinkRepository linkRepository;
	@Autowired
	LinkCheckRepository linkCheckRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	MessageRepository messageRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ClientModel clientModel = new ClientModel(1L,"Ime Prezime","email@email","napomena", sdf.format(Timestamp.valueOf(LocalDateTime.now())));
		LinkModel linkModel = new LinkModel(1L,"url",45.23, sdf.format(Timestamp.valueOf(LocalDateTime.now())));
		LinkCheckModel linkCheckModel = new LinkCheckModel(1L,"url","status", sdf.format(Timestamp.valueOf(LocalDateTime.now())));
		UserModel userModel = new UserModel(2L,"ADMIN","ime","prezime","user3", new BCryptPasswordEncoder().encode("pass3"),"tema");
		MessageModel messageModel = new MessageModel();

		List<LinkModel> list = new ArrayList<>();
		list.add(linkModel);
		List<LinkCheckModel> list1 = new ArrayList<>();
		list1.add(linkCheckModel);
		List<ClientModel> list3 = new ArrayList<>();
		list3.add(clientModel);

		UserModel u = userRepository.save(userModel);
		ClientModel c = clientRepository.save(clientModel);

		linkModel.setKlijent(clientRepository.getById(c.getId()));
		linkModel.setKorisnik(userRepository.getById(u.getId()));
		linkRepository.save(linkModel);
		linkRepository.save(linkModel);
		linkRepository.save(linkModel);
		linkCheckModel.setKlijent(clientRepository.getById(c.getId()));
		linkCheckModel.setKorisnik(userRepository.getById(u.getId()));
		linkCheckRepository.save(linkCheckModel);
		linkCheckRepository.save(linkCheckModel);
		LinkCheckModel lcm = linkCheckRepository.save(linkCheckModel);

		messageModel.setId(1L);
		messageModel.setPoruka("poruka");
		messageModel.setStatus("ZA_STEFANA");
		messageModel.setVremePoruke(sdf.format(Timestamp.valueOf(LocalDateTime.now())));
		messageModel.setLinkZaProveru(lcm);
		messageRepository.save(messageModel);
		messageModel.setPoruka("poruka1");
		messageModel.setStatus("ZA_MENADZERA");
		messageModel.setVremePoruke(sdf.format(Timestamp.valueOf(LocalDateTime.now())));
		messageRepository.save(messageModel);
		messageModel.setPoruka("poruka2");
		messageModel.setStatus("ZA_MENADZERA");
		messageModel.setVremePoruke(sdf.format(Timestamp.valueOf(LocalDateTime.now())));
		messageRepository.save(messageModel);

		List<LinkModel> linkovi = linkRepository.findAll();
		for(LinkModel l: linkovi){
			if(l.getKlijent().getId() == 17){
				System.out.println(l.getId());
			}
		}

	}
}
