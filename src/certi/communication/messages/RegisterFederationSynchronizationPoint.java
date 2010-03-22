// ----------------------------------------------------------------------------
// CERTI - HLA Run Time Infrastructure
// Copyright (C) 2010 Andrej Pancik
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
package certi.communication.messages;

import certi.communication.CertiException;
import certi.communication.MessageBuffer;
import certi.communication.CertiMessageType;
import certi.communication.CertiMessage;
import hla.rti.FederateHandleSet;

public class RegisterFederationSynchronizationPoint extends CertiMessage {

    private String label;
    private byte[] tag;
    private boolean booleanValue;
    private FederateHandleSet attributes;

    public RegisterFederationSynchronizationPoint() {
        super(CertiMessageType.REGISTER_FEDERATION_SYNCHRONIZATION_POINT);
    }

    @Override
    public void writeMessage(MessageBuffer messageBuffer) {
        super.writeMessage(messageBuffer); //Header

        messageBuffer.write(label);
        messageBuffer.writeBytesWithSize(tag);
        messageBuffer.write(booleanValue);
        if(booleanValue)
        messageBuffer.write(attributes);
    }

    @Override
    public void readMessage(MessageBuffer messageBuffer) throws CertiException {
        super.readMessage(messageBuffer); //Header

        label = messageBuffer.readString();
        tag = messageBuffer.readBytesWithSize();
        booleanValue = messageBuffer.readBoolean();
        if(booleanValue)
        attributes = messageBuffer.readFederateHandleSet();
    }

    @Override
    public String toString() {
        return (super.toString() + ", label: " + label + ", tag: " + tag + ", booleanValue: " + booleanValue + ", attributes: " + attributes);
    }

    public String getLabel() {
        return label;
    }

    public byte[] getTag() {
        return tag;
    }

    public boolean getBooleanValue() {
        return booleanValue;
    }

    public FederateHandleSet getAttributes() {
        return attributes;
    }

    public void setLabel(String newLabel) {
        this.label = newLabel;
    }

    public void setTag(byte[] newTag) {
        this.tag = newTag;
    }

    public void setBooleanValue(boolean newBooleanValue) {
        this.booleanValue = newBooleanValue;
    }

    public void setAttributes(FederateHandleSet newAttributes) {
        this.attributes = newAttributes;
    }
}
