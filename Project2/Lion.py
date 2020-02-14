import random
from Feline import Feline

class Lion(Feline):

  '''
    Generic initializer for Lion
    @param name:String, default:'Lily'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
  '''
  def __init__(self, name='Lily', awake=False, hungry=True, num_legs=4):
    super(Lion, self).__init__(name, awake, hungry, num_legs)

  '''
    Lion makes a noise with the following probability
      - 25% chance to purr
      - 25% chance to grumble
      - 25% chance to roar loudly
  '''
  def make_noise(self):
    animal_type = type(self).__name__
    random_number = random.random()
    if(random_number < 0.25):
      print('{} the {} purred.'.format(self.name, animal_type))
    elif(random_number < 0.5):
      print('{} the {} grumbles.'.format(self.name, animal_type))
    else:
        print('{} the {} roars loudly.'.format(self.name, animal_type))
