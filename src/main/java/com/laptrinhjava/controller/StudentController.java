package com.laptrinhjava.controller;

import java.util.List;
import java.util.Scanner;

import com.laptrinhjava.dto.StudentDTO;
import com.laptrinhjava.repository.impl.StudentRepository;
import com.laptrinhjava.service.IStudentService;
import com.laptrinhjava.service.impl.StudentService;

public class StudentController {
	public static void main(String[] args) {
		int funcion = 0;
		Scanner scanner = new Scanner(System.in);
		IStudentService studentService = new StudentService();
		StudentRepository studentRepository = new StudentRepository();
		do {
			showMenu();
			funcion = scanner.nextInt();
			scanner.nextLine();
			switch (funcion) {
			case 0:
				scanner.close();
				break;
			case 1:
				String name;
				System.out.println("Nhâp ten : ");
				name = scanner.nextLine();
				int age;
				System.out.println("Nhâp tuoi : ");
				age = scanner.nextInt();
				scanner.nextLine();
				String address;
				System.out.println("Nhâp dia chi : ");
				address = scanner.nextLine();
				studentRepository.addStudent(name, age, address);
				break;
			case 2:
				long id;
				System.out.println("Nhâp id can update: ");
				id = scanner.nextLong();
				scanner.nextLine();
				String newname;
				System.out.println("Nhâp ten moi : ");
				newname = scanner.nextLine();
				int newage;
				System.out.println("Nhâp tuoi moi : ");
				newage = scanner.nextInt();
				scanner.nextLine();
				String newaddress;
				System.out.println("Nhâp dia chi moi : ");
				newaddress = scanner.nextLine();
				studentRepository.update(id, newname, newage, newaddress);
				break;
			case 3:
				long id1;
				System.out.println("Nhâp id can delete: ");
				id1 = scanner.nextLong();
				studentRepository.delete(id1);
				break;
			case 4:
				String key = null;
				System.out.println("Nhâp từ khóa cần tìm : ");
				key = scanner.nextLine();
				List<StudentDTO> students = studentService.seach(key);
				for (StudentDTO item : students) {
					System.out.println("ID : " + item.getId() + " | " + " StudentName : " + item.getName() + " | "
							+ " StudentAge : " + item.getAge() + " | " + " Address : " + item.getAddress());
				}
				break;
			case 5:
				List<StudentDTO> s = studentService.findAll();
				for (StudentDTO item : s) {
					System.out.println("ID : " + item.getId() + " | " + " StudentName : " + item.getName() + " | "
							+ " StudentAge : " + item.getAge() + " | " + " Address : " + item.getAddress());
				}
				break;
			}
		} while (funcion != 0);

	}

	public static void showMenu() {
		System.out.println("-----------menu------------");
		System.out.println("1. Add student.");
		System.out.println("2. Edit student by id.");
		System.out.println("3. Delete student by id.");
		System.out.println("4. Seach Student by Name.");
		System.out.println("5. Show student.");
		System.out.println("0. exit.");
		System.out.println("---------------------------");
		System.out.print("Please choose: ");
	}
}