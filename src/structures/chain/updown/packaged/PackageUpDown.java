package structures.chain.updown.packaged;

import structures.chain.updown.ChainUpDown;
import structures.chain.updown.ChainUpDownElement;

/**
 * Package of a double-linked, packaged chain
 * 
 * @author Moritz Decker 
 * @version v1.0.1-2021-09-23
 */
public class PackageUpDown<E> extends ChainUpDown<E>
{
    public PackageUpDown(ChainUpDownElement<E> firstElement)
    {
        setFirstElement(firstElement);
        setLastElement(firstElement);
        this.length = 1;
    }
    
    public PackageUpDown(ChainUpDownElement<E> firstElement, int length)
    {
        super();
        this.setFirstElement(firstElement);
        this.length = length;
        this.setLastElement(getElement(length-1));
    }
    
    public PackageUpDown(ChainUpDownElement<E> firstElement, ChainUpDownElement<E> lastElement)
    {
        super();
        this.setFirstElement(firstElement);
        this.setLastElement(lastElement);

        if(firstElement != null && lastElement != null) {
            ChainUpDownElement<E> currentCountElem = firstElement;

            while(currentCountElem != lastElement) {
                if(currentCountElem != null) {
                    this.length++;
                } else {
                    break;
                }
                currentCountElem = currentCountElem.getNext();
            }
        }
    }

    public PackageUpDown<E> split()
    {
        int newLength = this.length / 2;

        PackageUpDown<E> nextPackage = new PackageUpDown<>(getElement(newLength), this.length-newLength);
    
        this.length = newLength;

        return nextPackage;
    }

    @Override
    public ChainUpDownElement<E> getElement(int index) {
        return super.getElement(index);
    }
}