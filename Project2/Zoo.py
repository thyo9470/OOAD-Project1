from Animal import Animal
from Canine import Canine
from Dog import Dog
from Wolf import Wolf

class Zoo():

  '''
    Initializes Zoo by calling populate function 
  '''
  def __init__(self):
    self.animals = []
    self.populate()

  '''
    Adds an animal to the zoo
    @param animal:Animal
  '''
  def add_animal(self, animal):
    self.animals.append(animal) 

  '''
    Returns the animals in the zoo
    @return animals:list(Animal)  
  '''
  def get_animals(self):
    return self.animals

  '''
    Populates the zoo with two of each animal 
  '''
  def populate(self):

    # Canine
    self.animals.append(Dog())
    self.animals.append(Dog('Dug'))
    self.animals.append(Wolf())
    self.animals.append(Wolf('Wifi'))
  
  '''
    Deletes all animals in zoo and sets animals list to empty   
  '''
  def clear_animals(self):
    for animal in self.animals:
      del animal 
    self.animals = []

