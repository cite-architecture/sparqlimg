package edu.holycross.shot.sparqlimg

import edu.harvard.chs.cite.CiteUrn

import static org.junit.Assert.*
import org.junit.Test

class TestRedirect extends GroovyTestCase {
    // use default fuseki settings to test
    String serverUrl = "http://localhost:3030/ds/"
    String iipsrv = "http://beta.hpcc.uh.edu/fcgi-bin/iipsrv.fcgi"

    String tstImg = "urn:cite:ecod:codbod8.cb-0008_001r"
    CiteUrn tstUrn = new CiteUrn(tstImg)


    void testRedirect() {
        CiteImage chsi = new CiteImage(serverUrl, iipsrv)
        String expectedRedirect = "http://beta.hpcc.uh.edu/fcgi-bin/iipsrv.fcgi?OBJ=IIP,1.0&FIF=/project/homer/pyramidal/CodBod8/cb-0008_001r.tif"
        assert  chsi.getBinaryRedirect(tstImg) == expectedRedirect
    }


}
