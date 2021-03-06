//Virtual Key For Your Repository Phase 1 Assesment
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
class FOperation {
	String folder;;
	Scanner sr;
	FOperation()
	{
		folder="C:\\Users\\HP\\Desktop\\PracticePrograms";

		sr=new Scanner(System.in);
	}
	public void home() {

		System.out.println("Virtual Key for your Repository");
		System.out.println("--------Developer Details---------");
		System.out.println("Name : Rexina D");
	}
	public void getfiles()
	{
		String files[];
		File file=new File(folder);
		files=file.list();
		for(String name:files)
		{
			File file1=new File(folder+"\\"+name);
			if(!file1.isDirectory())
			System.out.println(name);
		}
	}
	public void searchf()
	{
		System.out.println("Enter the file name");
		String fileName=sr.next();
		File file=new File(folder+"\\"+fileName);
		if(file.exists())
		{
			System.out.println("File exists.....");
		}
		else {
			System.out.println("File doesn't exist");
		}
	}
	public void addf()
	{
		System.out.println("Enter the file name");
		String fileName=sr.next();
		try {
		File file=new File(folder);
		File file1=new File(folder+"\\"+fileName);
		if(file1.exists())
		{
			System.out.println("File already exists");
		}
		else {
		FileOutputStream fos=new FileOutputStream(file+"\\"+fileName);
		fos.close();
		System.out.println("File added successfully....");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void deletef()
	{
		String name;
		System.out.println("Enter the file to be deleted ");
		name=sr.next();
		File file=new File(folder+"\\"+name);
		if(file.exists())
		{
			file.delete();
			System.out.println("File deleted successfully......");
		}
		else {
			System.out.println("File doesn't exist");
		}
	}

}
public class main
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch;
		Scanner sr=new Scanner(System.in);
		FOperation fo =new FOperation();
		fo.home();
		do {

			System.out.println("1. Retrieve files in Ascending Order\n2.Business Level Operation");
			System.out.println("3.Exit\nEnter your choice");
			ch=sr.nextInt();
			switch(ch)
			{
				case 1:System.out.println("Retrieving files in ascending order"); 
					fo.getfiles();
						break;
				case 2:
					int ch1;
					do {
						System.out.println("Welcome to Business Operations");
						System.out.println("1. Add a File");
						System.out.println("2. Delete a File");
						System.out.println("3. Search a File");
						System.out.println("4. Go back to Main Menu");
						System.out.println("Please select ");
						ch1=sr.nextInt();
						switch(ch1)
						{
							case 1:System.out.println("You have chosen to add a file");
								fo.addf();
								break;
							case 2:System.out.println("You have chosen to delete a file");
									fo.deletef();
								break;
							case 3: System.out.println("You have chosen to search for a file");
								fo.searchf();
								break;
							case 4:System.out.println("Going back to main menu");
								break;
							default: System.out.println("Please select valid option");
						}
					}while(ch1!=4);
						break;
				case 3:
					System.out.println("-----------Thank You------------");
					System.exit(0);
				default: System.out.println("Please select valid option");
			}
		}while(ch!=3);
	}
}
