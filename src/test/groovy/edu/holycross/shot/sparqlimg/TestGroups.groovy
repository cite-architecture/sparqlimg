package edu.holycross.shot.sparqlimg

import edu.harvard.chs.cite.CtsUrn

import static org.junit.Assert.*
import org.junit.Test

class TestGroups extends GroovyTestCase {
    // use default fuseki settings to test
    String serverUrl = "http://localhost:3030/ds/"
    String iipsrv = "http://beta.hpcc.uh.edu/fcgi-bin/iipsrv.fcgi"

    void testGroupInfo() {
        CiteImage chsi = new CiteImage(serverUrl, iipsrv)
        def slurper = new groovy.json.JsonSlurper()
        String reply = chsi.getSparqlReply("application/json", chsi.qg.summarizeGroupsQuery())
        def parsedReply =  slurper.parseText(reply)

        String expectedCount = "486"
        String expectedUrn = "urn:cite:ecod:codbod8"

        String actualCount 
        String actualUrn

        parsedReply.results.bindings.each { b ->
            actualCount = b.num.value
            actualUrn = b.archv.value
        }
        assert actualCount == expectedCount
        assert actualUrn == expectedUrn
    }


}
