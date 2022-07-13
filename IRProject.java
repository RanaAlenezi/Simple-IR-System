package IR;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USER
 */

    import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class IRProject {

    /**
     * @param args the command line /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
/**
 *
 * @author dalal
 */


    /**
     */
    public static String[] stopword = { "a","about","above","across","after","again","against","all","almost","alone","along","already","also","although","always","among","an","and","another"
            ,"any","anybody","anyone","anything","anywhere","are","area","areas","around","as","ask","asked","asking","asks","at","away","b","back","backed","backing","backs","be","became","because","become","becomes",
            "been","before","began","behind","being","beings","best","better","between","big","both","but","by","c","came","can","cannot","case","cases","certain","certainly","clear","clearly","come","could","d","did","differ"
            ,"different","differently","do","does","done","down","down","downed","downing","downs","during","e","each","early","either","end","ended","ending","ends","enough","even","evenly","ever","every","everybody","everyone",
            "everything","everywhere","f","face","faces","fact","facts","far","felt","few","find","finds","first","for","four","from","full","fully","further","furthered","furthering","furthers","g","gave","general","generally"
            ,"get","gets","give","given","gives","go","going","good","goods","got","great","greater","greatest","group","grouped","grouping","groups","h","had","has","have","having","he","her","here","herself","high","high","high","higher"
            ,"highest","him","himself","his","how","however","I","if","important","in","interest","interested","interesting","interests","into","is","it","its","itself","j","just","k","keep","keeps","kind","knew","know","known",
            "knows","l","large","largely","last","later","latest","least","less","let","lets","like","likely","long","longer","longest","m","made","make","making","man","many","may","me","member","members","men","might","more",
            "most","mostly","mr","mrs","much","must","my","myself","n","necessary","need","needed","needing","needs","never","new","new","newer","newest","next","no","nobody","non","noone","no","one","not","nothing","now","nowhere",
            "number","numbers","o","of","off","often","old","older","oldest","on","once","one","only","open","opened","opening","opens","or","order","ordered","ordering","orders","other","others","our","out","over","p","part",
            "parted","parting","parts","per","perhaps","place","places","point","pointed","pointing","points","possible","present","presented","presenting","presents","problem","problems","put","puts","q","quite","r","rather",
            "really","right","right","room","rooms","s","said","same","saw","say","says","second","seconds","see","seem","seemed","seeming","seems","sees","several","shall","she","should","show","showed","showing","shows","side",
            "sides","since","small","smaller","smallest","so","some","somebody","someone","something","somewhere","state","states","still","still","such","sure","t","take","taken","than","that","the","their","them","then","there"
            ,"therefore","these","they","thing","things","think","thinks","this","those","though","thought","thoughts","three","through","thus","to","today","together","too","took","toward","turn","turned","turning","turns","two",
            "u","under","until","up","upon","us","use","used","uses","v","very","w","want","wanted","wanting","wants","was","way","ways","we","well","wells","went","were","what","when","where","whether","which","while","who","whole","whose","why","will","with","within","without","work","worked","working","works","would","x","y","year","years","yet","you","young","younger","youngest","your","yours","z"};
    @SuppressWarnings("null")
    public static void main(String[] args) throws FileNotFoundException {
       
         JFileChooser fc = new JFileChooser();
         fc.showOpenDialog(fc);
        Scanner reader = null;  
        try {
     reader = new Scanner(fc.getSelectedFile());
            } catch (FileNotFoundException e) {  } 
        
        ArrayList<String> List = new ArrayList<>(); // List file
        ArrayList<String> StopWords = new ArrayList<>(); // List file Stop Words        
         
//        File file = new File("/Users/dalal/Desktop/text.txt"); 
//        Scanner reader = null;  
//        try{
//        reader =new Scanner(file);
//        }
//        catch(FileNotFoundException e){
//////        e.printStackTrace();
//        }
        
//        File StopWord = new File("/Users/dalal/Desktop/StopWords.txt"); // Arrive to file Stop Words
//        Scanner scan1 = new Scanner(StopWord); // Reading file Stop Words
        
        reader.useDelimiter("[^A-Za-z]+"); //Preprocessing
        
        // Tokenization and Normalization/
        while(reader.hasNextLine()){ 
            try {
                List.add(reader.next().toLowerCase()); // Make list each word lower case and token
            } catch (Exception e) {  } 
        }

        System.out.println("3.Normal = " + List + "\n");
       
        // Sorting /
        Collections.sort(List); 
        System.out.println("4.After Sort = " + List + "\n"); 
        
        // Removing Duplicates
         @SuppressWarnings("Convert2Diamond")
        Map<String,Integer> storeMap = new HashMap<String,Integer>();
        for (String word : List){
            Integer count = storeMap.get(word);
            if (count == null){
                storeMap.put(word , 1);
            }
            else{ storeMap.put(word , ++count); }
        }
        HashSet hs = new HashSet();
        hs.addAll(List);
        List.clear();
        List.addAll(hs);
        Collections.sort(List); 
        System.out.println("5.Remove duplicate " + List + "\n"); // Print after remove duplicate of list
       
        // Counting/
        int C1 = List.size(); 
        System.out.println("6.Count of the word in list = " + C1 + "\n"); 
        
        //Step  7
        System.out.println("7.Printing frequency ");
        Set<String> sett=storeMap.keySet();
        System.out.println(" _____________________________ ");
        System.out.println("  Word  "+"   |   "+"  Freq  ");
        System.out.println(" _____________________________ ");
        for(String key:sett){
            int value = storeMap.get(key);
            System.out.printf("%s \t\t  %d",key,value);
            System.out.println();
        }
        System.out.println("Total words \t "+C1);
   
        //Stop-Words Removal
        for(int i=0;i<=stopword.length;i++){
            try {
                StopWords.add(stopword[i]);
            } catch (Exception e) {}
        }
        for(int j =  0 ; j < StopWords.size() ; j++){
            for(int i =  0 ; i < List.size() ; i++){
                if (List.get(i).equalsIgnoreCase(StopWords.get(j))) {
                    List.remove(List.get(i));
                } 
            }
        }
        System.out.println("\n8.Remove stop words = " + List + "\n");
        
//        Printing and Computing Reduction
        double C2= List.size();
        Set<String> set = storeMap.keySet();
        System.out.println("9.Printing and Computing Reduction ");
        System.out.println(" _____________________________ ");
        System.out.println("  Word  "+"   |   "+"  Freq  ");
        System.out.println(" _____________________________ ");
        for(String key:set){
            int value=storeMap.get(key);
            System.out.printf("%s \t\t  %d",key,value);
            System.out.println();
        }
        System.out.println("Total words \t "+C2);
        System.out.println("\nReduction = "+ (C2/C1)*100 + "%\n");
         
    }}

