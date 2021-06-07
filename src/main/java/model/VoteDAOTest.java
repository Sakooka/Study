package model;

import java.util.ArrayList;
import java.util.List;

public class VoteDAOTest {

	public static void main(String[] args) {
		VoteDAO vd = new VoteDAO();
		List<Animals> allAnimals = new ArrayList<>();
		allAnimals = vd.findAll();
		for(Animals a : allAnimals) {
			System.out.println("ID:"+a.getId());
			System.out.println("NAME:"+a.getName());
			System.out.println("VOTES:"+a.getVotes());
		}

	}
}
