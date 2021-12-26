//Day1
def calcIncreaseStep(list: List[Int]): Int = 
  l.sliding(2).filter(n => n(1) > n(0)).toList.size

def readFileIntoList(path: String): List[Int] = {
      import scala.io.Source
      
      val list = Source.fromFile(path).getLines.toList
      list.map(l => if (!l.equals("")) Integer.parseInt(l) else 0)
}
//Day2


//Day3
def getFreqMap(lines: List[List[Char]]): Map[Int, Map[Char, Int]] = {

  val firstDigits = lines.filter(l => l.size > 0) map { l => 
    
  }
} 

def getFreqByColumn(digitsList: List[List[Char]], index: Int): Map[Char, Int] = {
  digitsList.map(l => l(index)).groupBy(identity).mapValues(_.size).toMap
}

def getGammaDigit(digitsList: List[List[Char]], index: Int): Char = { 
      val digitsMap =  getFreqByColumn(digitsList, index)                 
      if (digitsMap.get('0').get > digitsMap.get('1').get) '0' else '1'                
}

def getEpsilonDigit(digitsList: List[List[Char]], index: Int): Char = { 
      val digitsMap =  getFreqByColumn(digitsList, index)                 
      if (digitsMap.get('0').get <= digitsMap.get('1').get) '0' else '1'                
    }
val lines = Source.fromFile("/home/wild/projects/scala_projects/day1/input_3.txt").getLines.toList.map(l=>l.toList)

def getOxygenRate(index: Int, digitsList: List[List[Char]]): List[Char] = {
  if (digitsList.size == 1) digitsList(0)
  else {
    val gammaDigit = getGammaDigit(digitsList, index)
    getOxygenRate(index + 1, digitsList.filter(l => l(index) == gammaDigit))
  }
}


def getCarbonRate(index: Int, digitsList: List[List[Char]]): List[Char] = {
  if (digitsList.size == 1) digitsList(0)
  else {
    val epsilonDigit = getEpsilonDigit(digitsList, index)
    getOxygenRate(index + 1, digitsList.filter(l => l(index) == epsilonDigit))
  }
}


