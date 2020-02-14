import random
from Animal import Animal
from DevourBehavior import DevourBehavior

class Feline(Animal):

  '''
    Generic initializer for Feline
    @param name:String, default:'Flower'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
    @param eat_behavior:EatBehavior, default:DevourBehavior
  '''
  def __init__(self, name='Flower', awake=False, hungry=True, num_legs=4, eat_behavior=DevourBehavior):
    super(Feline, self).__init__(name, awake, hungry, num_legs, eat_behavior)

  '''
    Feline has a 25% chance to jump around and 75% chance to knock over a mug
  '''
  def roam(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.25 :
      print('{} the {} jumped around.'.format(self.name, animal_type))
    else:
      print('{} the {} knocked over a mug.'.format(self.name, animal_type))

  '''
    Feline meows
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    print('{} the {} meowed'.format(self.name, animal_type))

