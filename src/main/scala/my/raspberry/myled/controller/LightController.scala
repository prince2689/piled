package my.raspberry.myled.controller

import com.pi4j.io.gpio._
import org.springframework.web.bind.annotation.{RequestMapping, RestController}

@RestController
class LightController {

  private val pinController: GpioController = GpioFactory.getInstance()
  private val pin = pinController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW)

  @RequestMapping(Array("/"))
  def init(): String = {
    "LED Light !!!!"
  }

  @RequestMapping(Array("/toggle"))
  def toggle(): String = {
    pin.toggle()
    "Toggled !!"
  }

  @RequestMapping(Array("/blink"))
  def blink(): String = {
    pin.blink(200L, 10000L)
    "Blinked !!"
  }

}
