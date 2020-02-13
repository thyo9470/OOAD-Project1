
class EatBehavior():
  
  '''
    Makes EatBehavior not able to be instatiated
  '''
  def __new__(cls, *args, **kwargs):
          if cls is Animal:
              raise TypeError("Animal is an abstract class an cannot be instantiated")
          return object.__new__(cls, *args, **kwargs)

  def eat(name, animal_type):
    raise NotImplementedError('eat needs override') 
