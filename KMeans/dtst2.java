import java.util.Random;
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.File;

class dtst2{
    private float[][] dataset = new float[1200][2];

	public void createS2() {
			
        //createFile("dataset.txt");

            
        Random rand = new Random();
        


        //////float[][] dataset = new float[1200][2];
        //dataset[i][0] = rand.nextFloat() * (maxX - minX) + minX;
        for(int i = 0;i < 150;i++) { //1
            dataset[i][0] = (float) (rand.nextFloat() * (0.8 - 1.2) + 1.2);
            dataset[i][1] = (float) (rand.nextFloat() * (0.8 - 1.2) + 1.2);
        }
        for(int i = 150;i < 300;i++) { //2
            dataset[i][0] = (float) (rand.nextFloat() * (0 - 0.5) + 0.5);
            dataset[i][1] = (float) (rand.nextFloat() * (0 - 0.5) + 0.5);
        }
        for(int i = 300;i < 450;i++) { //3
            dataset[i][0] = (float) (rand.nextFloat() * (1.5 - 2) + 2);
            dataset[i][1] = (float) (rand.nextFloat() * (0 - 0.5) + 0.5);
        }
        for(int i = 450;i < 600;i++) { //4
            dataset[i][0] = (float) (rand.nextFloat() * (0 - 0.5) + 0.5);
            dataset[i][1] = (float) (rand.nextFloat() * (1.5 - 2) + 2);
        }
        for(int i = 600;i < 750;i++) { //5
            dataset[i][0] = (float) (rand.nextFloat() * (1.5 - 2) + 2);
            dataset[i][1] = (float) (rand.nextFloat() * (1.5 - 2) + 2);
        }
    
        for(int i = 750;i < 825;i++) { //6
            dataset[i][0] = (float) (rand.nextFloat() * (0 - 0.4) + 0.4);
            dataset[i][1] = (float) (rand.nextFloat() * (0.8 - 1.2) + 1.2);
        }
        for(int i = 825;i < 900;i++) { //7
            dataset[i][0] = (float) (rand.nextFloat() * (1.6 - 2) + 2);
            dataset[i][1] = (float) (rand.nextFloat() * (0.8 - 1.2) + 1.2);
        }
        for(int i = 900;i < 975;i++) { //8
            dataset[i][0] = (float) (rand.nextFloat() * (0.8 - 1.2) + 1.2);
            dataset[i][1] = (float) (rand.nextFloat() * (0.3 - 0.7) + 0.7);
        }
        for(int i = 975;i < 1050;i++) { //9
            dataset[i][0] = (float) (rand.nextFloat() * (0.8 - 1.2) + 1.2);
            dataset[i][1] = (float) (rand.nextFloat() * (1.3 - 1.7) + 1.7);
        }
        for(int i = 1050;i < 1200;i++) { //10
            dataset[i][0] = (float) (rand.nextFloat() * (0 - 2) + 2);
            dataset[i][1] = (float) (rand.nextFloat() * (0 - 2) + 2);
        }
    }

    public void writeToFile(){
		try {
      		FileWriter testWriter = new FileWriter("data.csv");
			for(int i=0;i<1200;i++){
				testWriter.write(dataset[i][0]+","+dataset[i][1]+"\n");
			}
			testWriter.close();
    	} 
    	catch (IOException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}		
	}

    public static void main(String[] args) {
        dtst2 obj = new dtst2();
		obj.createS2();
        obj.writeToFile();
	}
}