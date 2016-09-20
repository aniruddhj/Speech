package nlpProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

public class readCorpus {
	protected static StanfordCoreNLP pipeline = null;
	//static String[] stopWords = {"a", "as", "able", "about", "above", "according", "accordingly", "across", "actually", "after", "afterwards", "again", "against", "aint", "all", "allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any", "anybody", "anyhow", "anyone", "anything", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", "course", "currently", "definitely", "described", "despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", "just", "keep", "keeps", "kept", "know", "knows", "known", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides", "que", "quite", "qv", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", "ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "value", "various", "very", "via", "viz", "vs", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "zero"};
	static Map<String, Integer> countByWords = new TreeMap<String, Integer>();
	
	public readCorpus()
	{
		Properties props;
        props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma");
        pipeline = new StanfordCoreNLP(props);                    
	}
	
	public void posTag(String text) throws FileNotFoundException
	{
		
		
		LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
		//Scanner scanner = new Scanner(new File("D:\\Fall_2015\\NLP\\Barack_Obama_Grace_Jun26.txt"));
		//String text = scanner.useDelimiter("\\A").next();

		StringTokenizer st = new StringTokenizer(text);
		while (st.hasMoreTokens()) {

			String data = st.nextToken(" -_(.,:;!?\")").toLowerCase();

			List<CoreLabel> rawWords = Sentence.toCoreLabelList(data);
			Tree parse = lp.apply(rawWords);
			ArrayList ar = parse.taggedYield();

			for (Object o : ar) {
				String s = o.toString();
				String[] ss = s.split("/");
				// PrintWriter out = new
				// PrintWriter("D:\\Fall_2015\\NLP\\filename.txt");

				if (ss[1].contains("VB")) {
					//System.out.println(ss[0] + " " + ss[1]);
				}
			}
		}
		//scanner.close();

	}
	
	public void showQuotes(String text) throws FileNotFoundException 
	{
		//Scanner scanner = new Scanner( new File("D:\\Fall_2015\\NLP\\Barack_Obama_Grace_Jun26.txt"));
		//String text = scanner.useDelimiter("\\A").next();
		Pattern pattern = Pattern.compile("\"([^\"]*)\"");
		Matcher matcher = pattern.matcher(text);
		/*if (matcher.find()) {
		    System.out.println(matcher.group(1));
		}*/
		String returnstring = null;
		ArrayList<String> morethan3=new ArrayList<>();
		ArrayList<String> lessthan3=new ArrayList<>();
		while(matcher.find())
		{
			String matchString = matcher.group();
			String[] match = matchString.split(" ");
			if(match.length>3)
			{
				//System.out.println("quotes more than 3 words: "+matchString);
				//returnstring =  matchString;
				morethan3.add(matchString);
			}
			else
			{
			//	System.out.println("qoutes less than 3 words: " + matchString);
				lessthan3.add(matchString);
			}
		}
		System.out.println();
		System.out.println("The Quoted words are as follows ");
		System.out.println();
		Iterator itr=morethan3.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println();
		System.out.println("The Most Influential Words in a Speech are as follows: ");
		System.out.println();
		
		Iterator itr1=lessthan3.iterator();
		
		while(itr1.hasNext()){
			System.out.println(itr1.next());
		}
		//scanner.close();
		//return returnstring;
	}
		
	public void readcorpus(String text) throws FileNotFoundException
	{
		int total = 0;
			
//		Scanner scanner = new Scanner( new File("D:\\Fall_2015\\NLP\\Barack_Obama_Grace_Jun26.txt") );
//	String text = scanner.useDelimiter("\\A").next();
		
		ArrayList<String> stopWords1=new ArrayList<>();
		Scanner sc = new Scanner(new File("D:\\Fall_2015\\NLP\\stopwords1.txt"));
		
		while(sc.hasNext()){
			stopWords1.add(sc.next());
		}
		
		String stopWords[]=new String[stopWords1.size()];
		
		Iterator itr=stopWords1.iterator();
		int j=0;
		while(itr.hasNext()){
			stopWords[j]=(String) itr.next();
			j++;
		}
		
		StringTokenizer st = new StringTokenizer(text);
		while (st.hasMoreTokens()) {
			
			String data = st.nextToken(" —-–_(.,:;!?\")").toLowerCase();
			
			if (countByWords.containsKey(data)) {
				countByWords.put(data, countByWords.get(data) + 1);
			} else {
				countByWords.put(data, 1);
			}
			
		}
		
		//String test = avgWords(text);
		//scanner.close();
		for (int entry : countByWords.values()) {
			total = total + entry;
		}
		System.out.println("Total words (with stop words): " + total);
	
		System.out.println("Total words(without stop words): "+ countByWords.size());

		countByWords.keySet().removeAll(Arrays.asList(stopWords));
		System.out.println("Vocabulary Size of Speaker: "+ countByWords.size());
		
		
		System.out.println();	
		
		System.out.println("Percentage of Unique Words Spoken in a Speech by a Speaker: ");
		
		System.out.println("Most Used Words by a Speaker throughout the Speech: ");
		System.out.println();
		List<String> topWords = new ArrayList<>();
		TreeSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<Map.Entry<String, Integer>>(new ValueComparator());
		sortedSet.addAll(countByWords.entrySet());
		Iterator<Map.Entry<String, Integer>> iterator = sortedSet.iterator();
		for(int i = 1; i <= 20 && iterator.hasNext(); i++){
			Map.Entry<String, Integer> entry = iterator.next();
			topWords.add(entry.getKey());
			System.out.println(i + ". " + entry.getKey() + " (" + entry.getValue() + ")");
		}
		System.out.println();
		System.out.println("The Following are the Lemmatized Words for the Top 20 Words ");
		System.out.println();
		for(String s: topWords)
		{
			String str = lemmas(s);
			System.out.println(str);
		}
		
		//String quotewords = showQuotes(text);
		//System.out.println(quotewords);
	}
	
	public void avgWords(String paragraph) throws FileNotFoundException
	{
		//Scanner scanner = new Scanner( new File("D:\\Fall_2015\\NLP\\speech1.txt") );
		//String paragraph = scanner.useDelimiter("\\A").next();
		
		
		float count = 0;
		StringTokenizer st = new StringTokenizer(paragraph);
		while (st.hasMoreTokens()) {

			String data = st.nextToken(" -_(.,:;!?\")").toLowerCase();
			count++;
		}
		System.out.println();
		System.out.println("Total words in a Speech: "+count);
		System.out.println();

		BreakIterator bk = BreakIterator.getSentenceInstance(Locale.US);

		float sentences = count(bk, paragraph);
		System.out.println("Number of Sentences in a Speech: " + sentences);
		System.out.println();
		
		float avg = count / sentences;
		System.out.println("Average number of Words per sentence: " + avg);
	//scanner.close();
	}

	private static float count(BreakIterator bi, String source) {
		float counter = 0;
		bi.setText(source);

		int lastIndex = bi.first();
		while (lastIndex != BreakIterator.DONE) {
			int firstIndex = lastIndex;
			lastIndex = bi.next();
			int count = 0;
			if (lastIndex != BreakIterator.DONE) {
				String sentence = source.substring(firstIndex, lastIndex);
				counter++;
			}
		}
		return counter;

	}
	
	/*public void sentences(String in){
		Annotation document = new Annotation(in);
        pipeline.annotate(document);
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);
        ArrayList<String> s  = new ArrayList<>();
        for(CoreMap c : sentences){
        	s.add(c.toString());
        	System.out.println(s);
        }
	}*/

	public static String lemmas(String documentText)
	{
		List<String> lemmas = new LinkedList<String>();
        Annotation document = new Annotation(documentText);
        pipeline.annotate(document);
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);
        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
                lemmas.add(token.get(LemmaAnnotation.class));
            }
        }
        if(lemmas.size()>0)
        	return lemmas.get(0);
        else
        	return documentText;
	}
	
	public void POSTag(String text)
	{
		LexicalizedParser lp = LexicalizedParser.loadModel("edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz");
		
		StringTokenizer st = new StringTokenizer(text);
		float count = 0;
		float words = 0;
		while (st.hasMoreTokens()) {

			String data = st.nextToken(" -_(.,:;!?\")").toLowerCase();
			words++;
			List<CoreLabel> rawWords = Sentence.toCoreLabelList(data);
			Tree parse = lp.apply(rawWords);
			ArrayList ar = parse.taggedYield();
			for (Object o : ar) {
				String s = o.toString();
				String[] ss = s.split("/");
				if (ss[1].contains("VB")) {
					count++;
					//System.out.println(ss[0] + " " + ss[1]);
				}
			}
		}
		System.out.println("Total Action words in a Speech: "+count);
		System.out.println("Total words Spoken in a Speech: "+words);
		System.out.println("\"Doers\" attitude of a Speaker: "+ (count/words));

	}
	
	public void SentiAnalysis(String text)
	{
		Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        int mainSentiment = 0;
	Annotation document = new Annotation(text);
    pipeline.annotate(document);
    List<CoreMap> sentences = document.get(SentencesAnnotation.class);
    ArrayList<String> s  = new ArrayList<>();
    for(CoreMap c : sentences){
    	s.add(c.toString());
    //	System.out.println(s);
    }
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    float count=0;
    for(String name : s){
    if (name != null && name.length() > 0) {
        
    	Annotation annotation = (Annotation) pipeline.process(name);
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            Tree tree = sentence.get(SentimentCoreAnnotations.AnnotatedTree.class);
            mainSentiment = RNNCoreAnnotations.getPredictedClass(tree);
            count++;
            if(map.containsKey(mainSentiment)){
            	map.put(mainSentiment, map.get(mainSentiment)+1);
            }else{
            	map.put(mainSentiment, 1);
            }
        }
        
    }
    
    }
    float finalsentiment=0;
    for(Entry<Integer,Integer> entry: map.entrySet()){
    	
    	System.out.println(entry.getKey()+ " "+ entry.getValue());
    	finalsentiment+=entry.getKey()*entry.getValue();
    	
    }
    System.out.println("The Overall Sentiment for a Text is "+ finalsentiment/count);
   }
	
	public static void main(String args[]) throws FileNotFoundException  {
		Scanner scanner = new Scanner( new File("D:\\Fall_2015\\NLP\\Narendra_modi.txt") );
		String paragraph = scanner.useDelimiter("\\A").next();
		readCorpus rd = new readCorpus();
		rd.readcorpus(paragraph);
		rd.showQuotes(paragraph);
		rd.posTag(paragraph);
		rd.avgWords(paragraph);
		rd.POSTag(paragraph);
		rd.SentiAnalysis(paragraph);
		/*String test = "successful";
		String lemma = lemmas(test);
		System.out.println(lemma);*/
		
		//rd.sentences(paragraph);
		scanner.close();
	}
}

class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
	@Override
	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		if(o1.getValue() < o2.getValue()){
			return 1;
		}	
	   return -1;
	}
}