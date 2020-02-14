class Animal():

  '''
    Makes Animal not able to be instatiated
  '''
  def __new__(cls, name='Alvin', awake=False, hungry=True, num_legs=4, eat_behavior=None, *args, **kwargs):
          if cls is Animal:
              raise TypeError("Animal is an abstract class and cannot be instantiated")
          return object.__new__(cls, *args, **kwargs)

  '''
    Generic initializer for Animal 
    @param name:String, default:'Alvin'
    @param awake:Boolean, default:False
    @param hungry:Boolean, deault:True
    @param num_legs:Int, default:4
    @param eat_behavior:EatBehavior, default:None
  '''
  def __init__(self, name='Alvin', awake=False, hungry=True, num_legs=4, eat_behavior=None):
    self.name = name
    self.awake = awake
    self.hungry = hungry
    self.num_legs = num_legs
    self.eat_behavior = eat_behavior

  '''
    Makes animal wake up  
  '''
  def wake_up(self):
    animal_type = type(self).__name__
    if not self.awake :
      print('{} the {} woke up'.format(self.name, animal_type))
    else:
      print('{} the {} is already awake'.format(self.name, animal_type))

  '''
    Animal makes noise
    Note: Since there is no generic Animal sound it must be overridden in inherited classes
  '''
  def make_noise(self):
    raise NotImplementedError('make_noise needs override')

  '''
    Animal eats food
  '''
  def eat(self):
    if self.eat_behavior == None:
      raise NotImplementedError('This animal needs an EatBehavior')
    else:
      animal_type = type(self).__name__
      # TODO: I am not sure how to pass data to strategy pattern
      self.hungry = False
      self.eat_behavior.eat(self.name, animal_type)

  '''
    Animal roams around environement
  '''
  def roam(self):
    animal_type = type(self).__name__
    print('{} the {} began to roam'.format(self.name, animal_type))

  '''
    Animal goes to sleep
  '''
  def sleep(self):
    animal_type = type(self).__name__
    self.awake = False
    print('{} the {} fell asleep'.format(self.name, animal_type))

