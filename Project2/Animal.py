class Animal():

  # TODO: have EatBehavior variable

  def __init__(self, name, awake=False, hungry=True, numLegs=4):
    self.name = name
    self.awake = awake
    self.hungry = hungry
    self.numLegs = numLegs
  
  def wake_up(self):
    animal_type = type(self).__name__
    print('{} the {} woke up'.format(self.name, animal_type))

  def make_noise(self):
    raise NotImplementedError('make_noise needs override')

  # TODO: Add EatBehavior Call
  def eat(self):
    print('~~NEEDS TO BE IMPLEMENTED~~')
    raise NotImplementedError('need to have EatBehavior')

  def roam(self):
    animal_type = type(self).__name__
    print('{} the {} began to roam'.format(self.name, animal_type))

  def sleep(self):
    animal_type = type(self).__name__
    print('{} the {} fell asleep'.format(self.name, animal_type))

