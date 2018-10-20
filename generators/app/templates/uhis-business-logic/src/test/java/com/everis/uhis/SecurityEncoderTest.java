package com.everis.<%= appName %>;

import org.junit.Assert;
import org.junit.Test;

import com.everis.<%= appName %>.security.SecurityEncoder;

public class SecurityEncoderTest
{

    @Test
    public void testGenerateSalt()
    {
        String password = "123456";
        String salt = "1Hgow8kEdyhFI/NB4o6zRozLWZMfavrtpWSVsMATCtVr1IYR09F3ohbKF+G5MvBcq//+EFicwMpu98rEYWeLNrcSe1Kurl5O2m+wejJQDFLxXU45tgfguN3o2iA6s2eZ6L+es2+mlq0t2nqBG0tcGtig5jDENFO/xv0mCoV5Px1PZ8f6/oimf7HEtySiw4rvmpEIq4OMON3nmueiWyQ+ZTARBBxaEUfZJXAEO+aQ1LZKtiuaTKoFVeU/UVULd/Bcs2ScfXI98MKMthzePJ9cyEFQruMTDQfcKt5HLztU9vGiyXBj0Nqi61mtSl12Naas4iosCppMebZWEgWq8MMc1dCUGCj6R5/7jINUaMWI9qAHesjt35nFUxmNKM8AUKptGwyd5goIRWS1u8UPQB7G6YMDDg0ad3/vJoAJGiBoAWA0LlMkNrDBzOjIHPeZm2ICR/TyLfI8sTny11IyNEceZJX3Y7GZAH4cdGMR4XykR/h/9OS36CrLRcb96ezBVRCgsleyLlEXaKQom3USAx9DL/zabe1ZPHCdwhS8j6ZUiox1GgN2aYWYPVtvW1/RP8d0lCSq+25WAtxNZ1ZRZ12XAskoK4eLW3K6mfl9MNYT8F/pQLxvRjQDq64yOeQ94aIJqqru7ZlTQO4GBevGl33b9KvhLp10JfU81Mt0gq8TNzTU6jMvIfowHIZIZwbAWp//bEgPsA8clrRC8rsVZVX9geRJfxsUknwXskZYi0unf9hJWC3jhZ5eoPcdNofgK06QWCvJocjiY4h4Hgod6c7az3DUq2Ci7Y2K2VpqH7vsr7C4kDM+Xjvxe83vBDEwlnjqhWLmZd/QC9sz3TPOH2EhCwboYAToFbCu/A5k001wp5u/sDIe0r/MIR9JRCblcShhjvdpYTVd2JC26xrPo+GXGaib0/ao9Yw7zu7HddUnzahpkN+RY531lf0yVsrapJFqne144Erfa2SO40agyf+FvdZMgsoW0WlQd+YIYDB8mWJyHomhKtvzdTnnd3r3Q9JG";
        String expectedPasswordHash = "f2780582a582802d8ccb6e6441d2c5ad0eb3c34f1084e3fc8addeae589e2d7c8";
        boolean checkSalt;

        checkSalt = SecurityEncoder.checkSaltedPassword(password, salt, expectedPasswordHash);

        Assert.assertTrue("should be expected Password", checkSalt);
    }

}
