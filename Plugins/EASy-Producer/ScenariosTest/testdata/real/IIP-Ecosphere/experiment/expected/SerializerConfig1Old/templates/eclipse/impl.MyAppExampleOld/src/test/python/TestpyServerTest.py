import unittest

import sys
import os
import argparse

sys.path.insert(6, "../../../target/pySrc/iip")
sys.path.insert(7, "../../../target/pySrc")
from TestUtils import runTestsFromFile, runTestsFromTestFile, readTestDataJson, runAllTestsFromFile
""" will be the relative paths from impl.impl to impl.model, given through pom /gen onwards! """
sys.path.insert(1, "../../../gen/hm23/ApplicationInterfaces/src/main/python")
sys.path.insert(2, "../../../gen/hm23/ApplicationInterfaces/src/main/python/iip")
""" always fixed value as these directories are generated in the impl.impl """
sys.path.insert(3, "../../main/python/services")
sys.path.insert(5, "../../main/python/services")
sys.path.insert(4, "../../main/python")
import time
from Service import ServiceState
import json
from TestpyServer import TestpyServer

os.chdir("../../main/python")

class TestpyServerTest(unittest.TestCase):

    def test_inputTest(self):
    
        # Change name to correct .json, access rawData for values i.e. rawData["InputType"]["Value1"]
        rawData = ""
    
        server =  TestpyServer()

        server.setState(ServiceState.STARTING)                
        server.setState(ServiceState.RUNNING)
        
        server.setState(ServiceState.STOPPING)  
        server.setState(ServiceState.STOPPED)  

        # do your asserts here
        self.assertTrue(True)

if __name__ == "__main__":
    """ Makes unittest and argparse work together """
    unittest.main(argv=["first-arg-is-ignored"], exit=False)
