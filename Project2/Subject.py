from Observer import Observer

class Subject():

  '''
    Makes Subject not able to be instatiated
  '''
  def __new__(cls, *args, **kwargs):
          if cls is Subject:
              raise TypeError("Subject is an abstract class and cannot be instantiated")
          return object.__new__(cls, *args, **kwargs)

  '''
    Generic initializer for subject
  '''
  def __init__(self):
    self.observers = []

  '''
    Registers an observer with an object to be notified on state change
    @param observer:Observer
  '''
  def register_observer(observer):
    self.observers.append(observer)

  '''
    Removes observer from notify list 
    @param observer:Observer
  '''
  def remove_observer(observer):
    self.observers.remove(observer)

  '''
    Notifies all observers to update
  '''
  def notify_observers():
    for observer in self.observers:
      observer.update()
