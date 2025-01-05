import unittest

import sys
import os
import argparse

sys.path.insert(6, "../../../target/pySrc/iip")
sys.path.insert(7, "../../../target/pySrc")
from TestUtils import runTestsFromFile, runTestsFromTestFile, readTestDataJson, runAllTestsFromFile, getListOfDeserializedData
""" will be the relative paths from impl.impl to impl.model, given through pom /gen onwards! """
sys.path.insert(1, "../../../gen/hm23/ApplicationInterfaces/src/main/python")
sys.path.insert(2, "../../../gen/hm23/ApplicationInterfaces/src/main/python/iip")
""" always fixed value as these directories are generated in the impl.impl """
sys.path.insert(3, "../../main/python/services")
sys.path.insert(5, "../../main/python/services")
sys.path.insert(4, "../../main/python")

from Service import ServiceState
import json
from KodexPythonService import KodexPythonService
from datatypes.KRec13Anon import KRec13Anon
from datatypes.KRec13AnonImpl import KRec13AnonImpl
from serializers.KRec13AnonSerializer import KRec13AnonSerializer

os.chdir("../../main/python")

class KodexPythonServiceTest(unittest.TestCase):

    def test_inputTest(self):
        # Change name to correct .json, access rawData for values i.e. rawData["InputType"]["Value1"]
        rawData = ""
        service = KodexPythonService()

        service.setState(ServiceState.STARTING)
        service.setState(ServiceState.RUNNING)

        serializerKRec13Anon = KRec13AnonSerializer()
        

        service.attachIngestor(assertionIngestor) 

        runAllTestsFromFile(service.getId(), "../../test/resources/testData-KodexPythonService.json")
        
        # prepare your data, e.g., loading from json
        """ Needed to enable the loading of resources like the finished service would """

        # instantiate your service here, e.g., service = PyService()
        # call your service here, e.g., service.processNewInput(impl)

        service.setState(ServiceState.STOPPING)
        service.setState(ServiceState.STOPPED)	            

        # do your asserts here
        self.assertTrue(True)

def assertionIngestor(data):
    # add your assertions in this block, data will be your returned data
    print("output", data)

if __name__ == "__main__":
    """ Makes unittest and argparse work together """
    unittest.main(argv=["first-arg-is-ignored"], exit=False)
