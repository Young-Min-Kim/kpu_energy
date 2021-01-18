#include <MySQL_Connection.h>
#include <MySQL_Cursor.h>
#include <ESP8266WiFi.h> //와이파이
#include <stdio.h>

#include <DHT.h> //DHT11했던거 22도 동일한지는 모르겠음
#define DHTPIN D2
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);



//전류센서
#define CURRENT 30
const int analogIn = A0; //아날로그 입력 PIN    //여기는 1/18일 추가코드
int mVperAmp = 66; // 아날로그 입력 mV당 전류 값
// 30A 짜리는 66

int RawValue = 0;  // 아날로그 값 저장 변수  0~1024겟지

int ACSoffset = 2728; // 기준 값 0A일때 아날로그 값은 2500mV 이다.  데이터 시트 참고하면나옴 해당사진은 깃에 업로드 예정
//1510으로 일단 바꿔바
//다음 190더해서 2690 (2.8 -> 2.73)
//다음 400더함 3090 (이건 아니야) 2800으로 수정 --> 2750 하니까 0.33뜸 --> 2720하니까 0.13뜸 2701하니까 0.43??
//2710 은 0.29 2718은 0.16 2722은 0.11 2725는 0.06 
//마지막수정이되길 2727 0.03... 2728 가자 0.01... 아 끝 끝 끝 아 값 수정이제없다리 

//최종값 2728 여기에서 값 흔들리는 건 오차범위 이내

double Voltage = 0;   // 계산된 아날로그 값
double Amps = 0;      // 실제 측정된 전류 값

//이동 평균구하기 위함
int cnt = 0;
double smoothAmps = 0;

//wifi
const char* ssid = "SK_WiFiGIGA04C6_2.4G";
const char* password = "1803003041";

//sql 연결셋팅부
IPAddress server_addr(13, 209, 100, 19); // IP of the MySQL *server* here
//char hostname[] = "joljag.cshxrgoa1y2b.ap-northeast-2.rds.amazonaws.com"; // change to your server's hostname/URL
char user[] = "root";
char password_[] = "whfwkr16";        // MySQL user login password

WiFiClient client;
MySQL_Connection conn(&client);
MySQL_Cursor* cursor;

char INSERT_SQL[] = "INSERT INTO test_arduino.hello_arduino (message) VALUES ('Hello, Arduino!')";

void setup() {
  Serial.begin(115200); //전송속도

  Serial.println();
  Serial.println(ssid);
  WiFi.begin(ssid, password); // 와이파이 이름과 비밀번호를 통해 WIFI연결을 시작하겠다 // WL_CONNECTED라는 값을 돌려준다
  while (WiFi.status() != WL_CONNECTED) {
    // 네트워크의 연결 상태, 8개의 리턴값
    // STATUS와 WL_CONNECTED 값이 같은지를 통해 제대로 연결이 되있는지를 확인할 수 있다
    delay(500);
    Serial.print(".");
  }

  Serial.println();
  Serial.println("Wifi connected!");
  Serial.println("\nConnected to network");
  Serial.print("My IP address is: ");
  Serial.println(WiFi.localIP());

  Serial.print("Connecting to SQL...  ");
  if (conn.connect(server_addr, 3306, user, password_)) {
    Serial.println("OK.");
  }
  else {
    Serial.println("FAILED.");
  }
  // create MySQL cursor object
  cursor = new MySQL_Cursor(&conn);
}

void loop() {
  int h = dht.readHumidity();
  int t = dht.readTemperature();

  Serial.print("humidity:");          
  Serial.println(h);                  // 습도 값 출력
  Serial.print("temperature:");       
  Serial.println(t);                  // 온도 값 출력

  
  sprintf(INSERT_SQL, "INSERT INTO test.env VALUES (NOW(),%d,%d)", t, h); //쿼리문 온습도
  if (conn.connected()) {
    cursor->execute(INSERT_SQL);
  }
  while (1) {
    RawValue = analogRead(analogIn);
    Voltage = (RawValue / 1024.0) * 5000;
    Amps = ((Voltage - ACSoffset) / mVperAmp);
    smoothAmps = Amps * 0.01 + smoothAmps * 0.99;
    if ( cnt++ > 100 ) {
      //Serial.print("Volt : ");
      //Serial.println(Voltage / 1000);
      Serial.print("smoothAmps : ");
      Serial.println(smoothAmps);
      break;
    }
    delay(1);
  }
  cnt = 0;
  
  sprintf(INSERT_SQL, "INSERT INTO test.elec_stat VALUES (NOW(),%d,777)", smoothAmps); //쿼리문 온습도
  if (conn.connected()) {
    cursor->execute(INSERT_SQL);
  }
  
  delay(600000); //60초마다 반복해 10분마다
}
