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
import certi.rti.impl.CertiHandleValuePairCollection;
import hla.rti.AttributeHandleSet;
import hla.rti.SuppliedAttributes;
import certi.rti.impl.CertiExtent;
import java.util.List;
import hla.rti.Region;
import hla.rti.FederateHandleSet;
import hla.rti.SuppliedParameters;
import certi.rti.impl.CertiLogicalTime;
import certi.rti.impl.CertiLogicalTimeInterval;
import hla.rti.LogicalTime;
import hla.rti.LogicalTimeInterval;
import hla.rti.ReflectedAttributes;
import hla.rti.ReceivedInteraction;

public class ChangeAttributeOrderType extends CertiMessage {
   private long transport;
   private long order;
   private long object;
   private AttributeHandleSet attributes;

   public ChangeAttributeOrderType() {
      super(CertiMessageType.CHANGE_ATTRIBUTE_ORDER_TYPE);
   }

   @Override
   public void writeMessage(MessageBuffer messageBuffer) {
      super.writeMessage(messageBuffer); //Header

      messageBuffer.write(transport);
      messageBuffer.write(order);
      messageBuffer.write(object);
      messageBuffer.write(attributes);
   }

   @Override
   public void readMessage(MessageBuffer messageBuffer) throws CertiException {
      super.readMessage(messageBuffer); //Header 

      transport = messageBuffer.readLong();
      order = messageBuffer.readLong();
      object = messageBuffer.readLong();
      attributes = messageBuffer.readAttributeHandleSet();
   }

   @Override
   public String toString() {
      return (super.toString() + ", transport: " + transport + ", order: " + order + ", object: " + object + ", attributes: " + attributes);
   }

   public long getTransport() {
      return transport;
   }

   public long getOrder() {
      return order;
   }

   public long getObject() {
      return object;
   }

   public AttributeHandleSet getAttributes() {
      return attributes;
   }

   public void setTransport(long newTransport) {
      this.transport = newTransport;
   }

   public void setOrder(long newOrder) {
      this.order = newOrder;
   }

   public void setObject(long newObject) {
      this.object = newObject;
   }

   public void setAttributes(AttributeHandleSet newAttributes) {
      this.attributes = newAttributes;
   }

}
