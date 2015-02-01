This is the "Ecosystem" extension case for the PL_SimElevator.

- Checkout this project
- Checkout PL_SimElevator as PL_SimElevatorEco (initially intended to do instantiation there...)
  - check whether an update of EASy/.PLSimElevatorEco is required
- Open product line editor
- Configure just floors and elevators (others hidden through "Ecosystem" interface)
- Call propagate (IMPORTANT, these values are just available after propagation)
- Instantiate (shall fill out src and resources)
- Run src-local/maintenance/Main instead of src/main/Main
  -> Maintenance listener shall show selected floors on console
  -> Fire icon shall be different

For demo: Switch off .resources

Please note: Currently, this demo requires an always true in 
de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.FrozenVariablesFilter