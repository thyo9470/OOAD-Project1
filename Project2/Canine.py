import random
from Animal import Animal
from BiteBehavior import BiteBehavior

class Canine(Animal):

  '''
    Generic initializer for Canine 
    @param name:String, default:'Alvin'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
    @param eat_behavior:EatBehavior, default:None
  '''
  def __init__(self, name='Carl', awake=False, hungry=True, num_legs=4, eat_behavior=BiteBehavior):
    super(Canine, self).__init__(name, awake, hungry, num_legs, eat_behavior)

  '''
    Canine has a 25% chance to
      - roll over for belly rubs
      - chase their tail
      - hide in their cave
      - look for meat to eat 
    @override roam function from Animal
  '''
  def roam(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if random_number < 0.25 :
      print('{} the {} rolled over for belly rubs.'.format(self.name, animal_type))
    elif random_number < 0.5 :
      print('{} the {} chased their tail.'.format(self.name, animal_type))
    elif random_number < 0.75 :
      print('{} the {} hid in their cave.'.format(self.name, animal_type))
    else :
      print('{} the {} looked for some meat to eat.'.format(self.name, animal_type))

  '''
    Canine growls 
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    print('{} the {} growled'.format(self.name, animal_type))
    
