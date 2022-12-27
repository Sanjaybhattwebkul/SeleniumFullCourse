File  ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtil.copyFile(ss,new File("ss.png"));

WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visiblityOfElementedLocated(driver.findElement(By.xpath("//tr/td[1"))));

driveer.manage().timeouts().implicitlyWait(Duration.OfSeconds(10));

HttpURLConnection con = new URL(href).openConnection();
conn.setRequestMethod("HEAD");
conn.connect()
if(conn.getResponseCode){
    System.out.println("This is broken link");
}


Scanner sc = new Scanner(System.in);
System.out.println("Enter any value");
String inputs = sc.nextLine().replaceAll("\\s","");
char[] str = inputs.toCharArray();
HashMap<Character,Integer>map = new HshMap<Character,Integer>();

for(char words:str){
    if(map.containskeys(words)){
        map.put(words,map.get(words)+1);
    }else{
        map.put(word,1);
    }
}

System.out.println(map); // S->1 A->2,N->1 Y->3 



// get key and values
Scanner sc = new Scanner(System.in);
System.out.println("Enter any string");
String str = sc.nextLine();
String[] strArray = str.split(" ");
HashMap<String,Integer> map = new HashMap<String,Integer>();
for(string words:strArray){
    if(map.containsKey(words)) {
        map.put(words,map.get(words)+1);
    } else{
        map.get(words,1);
    }
}

// sort array
Collection<String> values = map.values();
Object[] obj = values.toArray();

for(int i=0;i<obj.length;i++)
 {
    int temp;
    for(j=0;j<obj.length-1;j++) {
        if(obj[i] > obj[j]) {
            temp = obj[i];
            obj[i] = obj[j];
            obj[j] = temp;
        }
    }
 }


 // get secnd heighest keys.

 for(Entry<String,Integer> entry:map.getValues()){
    if(entry.getValues == obj[1]) {
        System.out.prinln(entry.getKeys);
    }
 }














