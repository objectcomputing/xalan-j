/*
 * The Apache Software License, Version 1.1
 *
 *
 * Copyright (c) 1999 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *     the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:  
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Xalan" and "Apache Software Foundation" must
 *    not be used to endorse or promote products derived from this
 *    software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    nor may "Apache" appear in their name, without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation and was
 * originally based on software copyright (c) 1999, Lotus
 * Development Corporation., http://www.lotus.com.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
package org.apache.xalan.processor;

import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.Attributes;
import org.xml.sax.EntityResolver;
import org.xml.sax.DTDHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import org.apache.xalan.res.XSLMessages;
import org.apache.xalan.res.XSLTErrorResources;

import java.util.Vector;

/**
 * This class acts as the superclass for all stylesheet element 
 * processors, and deals with things that are common to all elements.
 * @see <a href="http://www.w3.org/TR/xslt#dtd">XSLT DTD</a>
 */
public class XSLTElementProcessor
{    
  /**
   * Construct a processor for top-level elements.
   * @see <a href="http://www.w3.org/TR/xslt#dtd">XSLT DTD</a>
   */
  XSLTElementProcessor()
  {
  }
  
  /**
   * The element definition that this processor conforms to.
   */
  private XSLTElementDef m_elemDef;

  /**
   * Get the element definition that belongs to this element.
   */
  XSLTElementDef getElemDef()
  {
    return m_elemDef;
  }

  /**
   * Set the element definition that belongs to this element.
   */
  void setElemDef(XSLTElementDef def)
  {
    m_elemDef = def;
  }
  
  /**
   * Resolve an external entity.
   *
   * @param publicId The public identifer, or null if none is
   *                 available.
   * @param systemId The system identifier provided in the XML 
   *                 document.
   * @return The new input source, or null to require the
   *         default behaviour.
   * @exception org.xml.sax.SAXException Any SAX exception, possibly
   *            wrapping another exception.
   * @see org.xml.sax.EntityResolver#resolveEntity
   */
  public InputSource resolveEntity (StylesheetHandler handler, 
                                    String publicId, String systemId)
    throws SAXException
  {
    return null;
  }
  
  
  /**
   * Receive notification of a notation declaration.
   *
   * @param name The notation name.
   * @param publicId The notation public identifier, or null if not
   *                 available.
   * @param systemId The notation system identifier.
   * @see org.xml.sax.DTDHandler#notationDecl
   */
  public void notationDecl (StylesheetHandler handler, 
                            String name, String publicId, String systemId)
  {
    // no op
  }
  
  
  /**
   * Receive notification of an unparsed entity declaration.
   *
   * @param name The entity name.
   * @param publicId The entity public identifier, or null if not
   *                 available.
   * @param systemId The entity system identifier.
   * @param notationName The name of the associated notation.
   * @see org.xml.sax.DTDHandler#unparsedEntityDecl
   */
  public void unparsedEntityDecl (StylesheetHandler handler, 
                                  String name, String publicId,
                                  String systemId, String notationName)
  {
    // no op
  }
  
  /**
   * Receive notification of the start of the non-text event.  This 
   * is sent to the current processor when any non-text event occurs.
   */
  public void startNonText(StylesheetHandler handler)
    throws SAXException
  {
    // no op
  }

  /**
   * Receive notification of the start of an element.
   *
   * @param name The element type name.
   * @param attributes The specified or defaulted attributes.
   * @exception org.xml.sax.SAXException Any SAX exception, possibly
   *            wrapping another exception.
   * @see org.xml.sax.ContentHandler#startElement
   */
  public void startElement (StylesheetHandler handler, 
                            String uri, String localName,
                            String rawName, Attributes attributes)
    throws SAXException
  {
    // no op
  }
  
  
  /**
   * Receive notification of the end of an element.
   *
   * @param name The element type name.
   * @param attributes The specified or defaulted attributes.
   * @exception org.xml.sax.SAXException Any SAX exception, possibly
   *            wrapping another exception.
   * @see org.xml.sax.ContentHandler#endElement
   */
  public void endElement (StylesheetHandler handler, 
                          String uri, String localName, String rawName)
    throws SAXException
  {
    // no op
  }
  
  
  /**
   * Receive notification of character data inside an element.
   *
   * @param ch The characters.
   * @param start The start position in the character array.
   * @param length The number of characters to use from the
   *               character array.
   * @exception org.xml.sax.SAXException Any SAX exception, possibly
   *            wrapping another exception.
   * @see org.xml.sax.ContentHandler#characters
   */
  public void characters (StylesheetHandler handler, 
                          char ch[], int start, int length)
    throws SAXException
  {
    handler.error("Characters are not allowed at this point in the document!", null);
  }
  
  
  /**
   * Receive notification of ignorable whitespace in element content.
   *
   * @param ch The whitespace characters.
   * @param start The start position in the character array.
   * @param length The number of characters to use from the
   *               character array.
   * @exception org.xml.sax.SAXException Any SAX exception, possibly
   *            wrapping another exception.
   * @see org.xml.sax.ContentHandler#ignorableWhitespace
   */
  public void ignorableWhitespace (StylesheetHandler handler, 
                                   char ch[], int start, int length)
    throws SAXException
  {
    // no op
  }
  
  
  /**
   * Receive notification of a processing instruction.
   *
   * @param target The processing instruction target.
   * @param data The processing instruction data, or null if
   *             none is supplied.
   * @exception org.xml.sax.SAXException Any SAX exception, possibly
   *            wrapping another exception.
   * @see org.xml.sax.ContentHandler#processingInstruction
   */
  public void processingInstruction (StylesheetHandler handler, 
                                     String target, String data)
    throws SAXException
  {
    // no op
  }


  /**
   * Receive notification of a skipped entity.
   *
   * @param name The name of the skipped entity.
   * @exception org.xml.sax.SAXException Any SAX exception, possibly
   *            wrapping another exception.
   * @see org.xml.sax.ContentHandler#processingInstruction
   */
  public void skippedEntity (StylesheetHandler handler, 
                             String name)
    throws SAXException
  {
    // no op
  }
  
  /**
   * Set the properties of an object from the given attribute list.
   * @param handler The stylesheet's Content handler, needed for 
   *                error reporting.
   * @param rawName The raw name of the owner element, needed for 
   *                error reporting.
   * @param attributes The list of attributes.
   * @param target The target element where the properties will be set.
   */
  void setPropertiesFromAttributes(StylesheetHandler handler,
                                   String rawName,
                                   Attributes attributes, 
                                   Object target)
    throws SAXException
  {
    XSLTElementDef def = getElemDef();

    // Keep track of which XSLTAttributeDefs have been processed, so 
    // I can see which default values need to be set.
    Vector processedDefs = new Vector();
    int nAttrs = attributes.getLength();
    for(int i = 0; i < nAttrs; i++)
    {
      String attrUri = attributes.getURI(i);
      String attrLocalName = attributes.getLocalName(i);
      XSLTAttributeDef attrDef = def.getAttributeDef( attrUri, attrLocalName );
      
      if(null == attrDef)
      {
        // Then barf, because this element does not allow this attribute.
        handler.error(attributes.getQName(i)+
                      "attribute is not allowed on the "+
              rawName+" element!", null);
      }
      else
      {
        processedDefs.addElement(attrDef);
        attrDef.setAttrValue(handler, attrUri, attrLocalName,
                             attributes.getQName(i), 
                             attributes.getValue(i),
                             target);
      }
    }
    
    XSLTAttributeDef[] attrDefs = def.getAttributes();
    int nAttrDefs = attrDefs.length;
    for(int i = 0; i < nAttrDefs; i++)
    {
      XSLTAttributeDef attrDef = attrDefs[i];
      String defVal = attrDef.getDefault();
      if(null != defVal)
      {
        if(!processedDefs.contains(attrDef))
        {
          attrDef.setDefAttrValue(handler, target);
        }
      }
      if (attrDef.getRequired())
      {
        if(!processedDefs.contains(attrDef))
          handler.error(XSLMessages.createMessage(XSLTErrorResources.ER_REQUIRES_ATTRIB, new Object[]{rawName, attrDef.getName()}) , null);    
      }    
    }

  }
  
}
