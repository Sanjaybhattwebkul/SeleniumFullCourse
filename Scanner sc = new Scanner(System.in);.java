Scanner sc   = new Scanner(System.in);
System.out.println("Enter Any Number or Value");
String inputs = sc.nextLine().replaceAll("\\s","");
char[] charArray = inputs.toCharArray();
HashMap<Character,Integer> map = new HashMap<Character,Integer>();
for(char words: charArray) {
    if(map.containsKey(words)) {
        map.put(words,map.getKeys(words)+1);
    } else{
        map.put(words,1);
    }
}

System.out.println(map); // print each character's count

Collection<Integer> values = map.getValues();
Objcet[] obj = values.toArray();
for(int i =0; i<obj.length()) {
    int temp;
    for(int j=0;j<obj.length;j++) {
        if(obj[i] > obj[j]) {
            temp = obj[i];
            obj[i] = obj[j];
            ibj[j] = temp;
        }
    }
}

for(Entry<Character,Integer> entry : map.entrySet()) {
    if(entry.getValues() == obh[1]) {
        System.out.printl("Second Heighest Occoring word is :  " + entry.getKeys() + "-> "+ entry.getValues());
    }
}





TakesScreenshot ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(ss,new File("ss.pgn"));

WebDriverWait wait = new WenDriverWait(driver,10)
wait.until(ExpectedCondition.visiblityOfElementLocated("locator"));



HttpURLConnection conn = new URL(hreh).openConnection();
conn.setRequestMethod("HEAD");
conn.connect();
int res = conn.geetResponceCode();
if(res>400) {
    System.out.println("Link is broken");
}









