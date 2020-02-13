class Animal():

  '''
    Makes Animal not able to be instatiated
  '''
  def __new__(cls, *args, **kwargs):
          if cls is Animal:
              raise TypeError("Animal is an abstract class an cannot be instantiated")
          return object.__new__(cls, *args, **kwargs)

  def __init__(self, name, awake=False, hungry=True, num_legs=4, eat_behavior=None):
    self.name = name
    self.awake = awake
    self.hungry = hungry
    self.num_legs = num_legs
    self.eat_behavior = eat_behavior
  
  def wake_up(self):
    animal_type = type(self).__name__
    print('{} the {} woke up'.format(self.name, animal_type))

  def make_noise(self):
    raise NotImplementedError('make_noise needs override')

  # TODO: Add EatBehavior Call
  def eat(self):
    if self.eat_behavior == None:
      raise NotImplementedError('This animal needs an EatBehavior')
    else:
      animal_type = type(self).__name__
      self.eat_behavior.eat(self.name, animal_type)

  def roam(self):
    animal_type = type(self).__name__
    print('{} the {} began to roam'.format(self.name, animal_type))

  def sleep(self):
    animal_type = type(self).__name__
    print('{} the {} fell asleep'.format(self.name, animal_type))

