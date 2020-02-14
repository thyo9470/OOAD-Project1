

class Observer():

  
  '''
    Makes Observer not able to be instatiated
  '''
  def __new__(cls, *args, **kwargs):
          if cls is Observer:
              raise TypeError("Observer is an interface and cannot be instantiated")
          return object.__new__(cls, *args, **kwargs)

  '''
    Interface for update function
  '''
  def update():
    raise NotImplementedError('update needs override')
