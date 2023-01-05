package bg.softuni.kotlin.kotlindemo.service

import org.springframework.stereotype.Service

@Service
class GreeterService {

    fun generateGreeting(name: String) : String {
      return "Hello, $name"
    }
}