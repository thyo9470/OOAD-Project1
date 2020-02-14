from Zookeeper import Zookeeper, KeeperState
from Observer import Observer

class ZooAnnouncer(Observer):
    
  '''
    Generic initializer for ZooAnnouncer
  '''
  def __init__(self):
    self.zookeeper = None

  '''
    Starts observing a given zookeeper 
    @param zookeeper:Zookeeper - the zookeeper
  '''
  def start_observing(self, zookeeper):
    self.zookeeper = zookeeper
    self.zookeeper.register_observer(self)

  '''
    Stops observing the zookeeper
  '''
  def finish_observing(self):
    self.zookeeper.remove_observer(self)
    self.zookeeper = None

  '''
    Will be called when the an observed zookeeper changes state
  '''
  def update(self):
    keeper_state = self.zookeeper.get_state()
    self.announce(keeper_state)

  '''
    Announces what a zookeeper is doing
    @param keeper_state: KeeperState - Enum in Zookeeper.py
  '''
  def announce(self, keeper_state):     
    announcement = 'Zoo Announcer: ' 
    if keeper_state == KeeperState.start:
      announcement += 'The zookeeper has just showed up at the zoo'
    elif keeper_state == KeeperState.wake_up:
      announcement += 'The zookeeper is waking up the animals'
    elif keeper_state == KeeperState.roll_call:
      announcement += 'The zookeeper is taking roll'
    elif keeper_state == KeeperState.feed_animals:
      announcement += 'The zookeeper is is feeding the animals'
    elif keeper_state == KeeperState.exercise_animals:
      announcement += 'The zookeeper is exercising the animals'
    elif keeper_state == KeeperState.put_animals_to_bed:
      announcement += 'The zookeeper is putting the animals to bed'
    elif keeper_state == KeeperState.end:
      announcement += 'The zookeeper is done with his work for the day'
    else:
      return
    print(announcement)
    
    
    


