// ----------------------------------------------------------------------------
// CERTI - HLA RunTime Infrastructure
// Copyright (C) 2011 Eric Noulard
//
// This program is free software ; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public License
// as published by the Free Software Foundation ; either version 2 of
// the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful, but
// WITHOUT ANY WARRANTY ; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program ; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
// ----------------------------------------------------------------------------
package hla.rti1516e.jlc;

import hla.rti1516e.encoding.ByteWrapper;
import hla.rti1516e.encoding.DecoderException;
import hla.rti1516e.encoding.EncoderException;

public class HLAunicodeCharImpl extends DataElementBase implements
        hla.rti1516e.encoding.HLAunicodeChar {

    private BasicHLAoctetPairBEImpl value;
    
    public HLAunicodeCharImpl() {
        value = new BasicHLAoctetPairBEImpl();
    }
    
    public HLAunicodeCharImpl(short c) {
        value = new BasicHLAoctetPairBEImpl(c);
    }
    
    
    public int getOctetBoundary() {
        return value.getOctetBoundary();
    }

    
    public void encode(ByteWrapper byteWrapper) throws EncoderException {
        value.encode(byteWrapper);
    }

    
    public int getEncodedLength() {
        return value.getEncodedLength();
    }

    
    public void decode(ByteWrapper byteWrapper) throws DecoderException {
        value.decode(byteWrapper);
    }

    
    public short getValue() {
        return value.getValue();
    }

    
    public void setValue(short value) {
        this.value.setValue(value);
    }

}
