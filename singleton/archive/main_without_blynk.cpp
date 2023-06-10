#include <Arduino.h>
#include <OneWire.h>
#include <DallasTemperature.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#define SCREEN_WIDTH 128
#define SCREEN_HEIGHT 64

#define OLED_RESET -1
#define SCREEN_ADDRESS 0x3D

/* DefiniÃ§Ã£o de pinos */
#define TEMP_PIN 25
#define HUMIDITY_PIN 34
#define WATER_LEVEL_PIN 26
#define PUMP_PIN 32
#define DISPLAY_BUTTON 33

/* InicializaÃ§Ãµes de pacotes */
OneWire oneWire(TEMP_PIN);
DallasTemperature sensors(&oneWire);
Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, OLED_RESET);

int temperature = 0;
int humidity = 0;
int waterLevel = 0;
bool displayMode = true;

bool offset(int prev, int next)
{
  if (prev != next && prev != next + 1 && prev != next - 1)
    return true;

  return false;
}

void printState() {
    Serial.print("Umidade: ");
    Serial.println(humidity);

    Serial.print("Temperatura: ");
    Serial.println(temperature);

    Serial.print("Nivel da agua: ");
    Serial.println(waterLevel);

    displayMode ? Serial.println("Display desligado!") : Serial.println("Display ligado!");

    digitalRead(PUMP_PIN) ? Serial.println("Bomba ligada!") : Serial.println("Bomba desligada!");
}

void togglePump() {
  if (!digitalRead(PUMP_PIN))
    {
      digitalWrite(PUMP_PIN, HIGH);
      Serial.println("Bomba ligada!");
    }
    else
    {
      digitalWrite(PUMP_PIN, LOW);
      Serial.println("Bomba desligada!");
    }
}

void setup()
{
  pinMode(HUMIDITY_PIN, INPUT);
  pinMode(PUMP_PIN, OUTPUT);
  pinMode(WATER_LEVEL_PIN, INPUT_PULLUP);
  pinMode(DISPLAY_BUTTON, INPUT_PULLUP);

  Serial.begin(9600);
  sensors.begin();

  if(!display.begin(SSD1306_SWITCHCAPVCC, SCREEN_ADDRESS)) {
    Serial.println(F("SSD1306 allocation failed"));
    for(;;);
  }

  display.display();
  display.setTextSize(2);
}

void loop()
{
  /* SeÃ§Ã£o da humidade */
  int tmpHumidity = map(analogRead(HUMIDITY_PIN), 0, 4095, 0, 100);
  if (offset(humidity, tmpHumidity))
  {
    humidity = tmpHumidity;

    Serial.print("Umidade: ");
    Serial.println(humidity);

    if (humidity <= 60 && !digitalRead(PUMP_PIN))
    {
      digitalWrite(PUMP_PIN, HIGH);
      Serial.println("Bomba ligada!");
    }
    else if (humidity > 60 && digitalRead(PUMP_PIN))
    {
      digitalWrite(PUMP_PIN, LOW);
      Serial.println("Bomba desligada!");
    }

    display.setCursor(10, 0);
    display.print("Umidade: ");
    display.print(humidity);
  }

  /* SeÃ§Ã£o da temperatura */
  int tmpTemperature = sensors.getTempCByIndex(0);
  if (offset(temperature, tmpTemperature))
  {
    temperature = tmpTemperature;

    Serial.print("Temperatura: ");
    Serial.println(temperature);

    display.setCursor(10, 10);
    display.print("Temperatura: ");
    display.print(temperature);
  }

  /* SeÃ§Ã£o do sensor de nÃ­vel */
  int tmpWaterLevel = digitalRead(WATER_LEVEL_PIN);
  if (offset(waterLevel, tmpWaterLevel))
  {
    waterLevel = tmpWaterLevel;

    Serial.print("Nivel da agua: ");
    Serial.println(waterLevel);
  }

  if (!digitalRead(DISPLAY_BUTTON))
  {
    if (displayMode)
    {
      // display.noBacklight();
      displayMode = false;

      Serial.println("Display desligado!");
    }
    else
    {
      // display.backlight();
      displayMode = true;

      Serial.println("Display ligado!");
    }
  }

  if (Serial.available() > 0) {
    String data = Serial.readString();
    if (data == "ReadState") {
      printState();
    } else if (data == "PumpToggle") {
      togglePump();
    }
  }

  delay(200);
}