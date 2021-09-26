package structures.chain.updown.packaged;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.Chain;
import structures.chain.ChainElement;
import structures.chain.down.ChainDownElement;
import structures.chain.updown.ChainUpDown;
import structures.chain.updown.ChainUpDownElement;
import structures.chain.util.ChainDownIterator;
import structures.chain.util.ChainUpDownListIterator;


public class PackagedChainUpDown<E> extends Chain<E>
{
    private static final int DEFAULT_PACKAGE_SIZE = 8;
    
    protected ChainUpDown<PackageUpDown<E>> packages;
    private int packageSize;

    public PackagedChainUpDown()
    {
        this.packages = new ChainUpDown<>();
        this.packageSize = DEFAULT_PACKAGE_SIZE;
    }

    public PackagedChainUpDown(int packageSize)
    {
        this.packages = new ChainUpDown<>();
        this.packageSize = packageSize;
    }

    @Override
    public boolean add(E obj)
    {
        if(packages.getLast() == null || packages.getLast().size() >= packageSize) {
            ChainUpDownElement<E> elem = new ChainUpDownElement<>(obj);
            
            elem.setPrev((ChainUpDownElement<E>) getLastElem());
            
            ChainUpDownElement<E> lastElem = (ChainUpDownElement<E>) getLastElem();
            if(lastElem != null) {
                lastElem.setNext(elem);
            }
            
            packages.add(new PackageUpDown<>(elem));
        }
        else {
            packages.getLast().add(obj);
        }

        length++;

        return true;
    }

    @Override
    public void add(int index, E obj) throws ChainIndexOutOfBoundsException
    {
        if(index < 0 || index > length) {
            throw indexOutOfBounds(index);
        }
        
        int i = 0;

        if(packages.size() == 0) {
            add(obj);
        }
        else {
            for(PackageUpDown<E> pkg: packages) {
                if(i + pkg.size() >= index) {
                    pkg.add(index-i, obj);
                }
                
                i+= pkg.size();
            }
        
            length++;
        }
    }

    @Override
    public void clear()
    {
        packages.clear();
    }

    @Override
    public E get(int index) throws ChainIndexOutOfBoundsException
    {
        ChainUpDownElement<E> elem = (ChainUpDownElement<E>) getElem(index);

        if(elem == null) {
            throw indexOutOfBounds(index);
        }

        return elem.get();
    }

    protected PackageUpDown<E> getFirstPackage()
    {
        return this.packages.getFirst();
    }

    protected PackageUpDown<E> getLastPackage()
    {
        return this.packages.getLast();
    }

    @Override
    public E getFirst()
    {
        PackageUpDown<E> firstPackage = getFirstPackage();
        
        if(firstPackage == null) {
            return null;
        }

        return firstPackage.getFirst();
    }

    @Override
    public E getLast()
    {
        PackageUpDown<E> lastPackage = getLastPackage();
        
        if(lastPackage == null) {
            return null;
        }

        return lastPackage.getLast();
    }

    @Override
    public ChainElement<E> getFirstElem()
    {
        PackageUpDown<E> firstPackage = getFirstPackage();
        
        if(firstPackage == null) {
            return null;
        }

        return firstPackage.getFirstElem();
    }

    @Override
    public ChainElement<E> getLastElem()
    {
        PackageUpDown<E> lastPackage = getLastPackage();
        
        if(lastPackage == null) {
            return null;
        }

        return lastPackage.getLastElem();
    }

    @Override
    public void setFirstElem(ChainElement<E> firstElement)
    {
        this.getFirstPackage().setFirstElem(firstElement);
    }

    @Override
    public void setLastElem(ChainElement<E> lastElement)
    {
        this.getLastPackage().setLastElem(lastElement);        
    }

    @Override
    public ChainUpDownListIterator<E> listIterator()
    {
        return new ChainUpDownListIterator<>(this, (ChainUpDownElement<E>) this.getFirstElem(), 0);
    }

    @Override
    public E remove(int index) throws ChainIndexOutOfBoundsException
    {
        int i = 0;

        E obj = null;

        for(PackageUpDown<E> pkg: packages) {
            if(i + pkg.size() > index) {
                obj = pkg.getElem(index-i).get();
                pkg.remove(index-i);
            }
            
            i+= pkg.size();
        }

        return obj;
    }

    @Override
    public ChainElement<E> getElem(int index)
    {
        int i = 0;

        for(PackageUpDown<E> pkg: packages) {
            if(i + pkg.size() > index) {
                return pkg.getElem(index-i);
            }
            
            i+= pkg.size();
        }

        return null;
    }

    /**
     * @param fromIndex
     * @param toIndex
     * @return new PackagedChainUpDown with contents of chain in between given indicies
     */
    @Override
    public PackagedChainUpDown<E> subList(int fromIndex, int toIndex)
    {
        PackagedChainUpDown<E> subChain = new PackagedChainUpDown<>();
        
        ChainDownElement<E> beginElem = (ChainDownElement<E>) getElem(fromIndex);
        ChainDownIterator<E> iter = new ChainDownIterator<>(beginElem);
        
        for(int i = 0; i <= toIndex - fromIndex; i++) {
            subChain.add(iter.next());
        }
        
        return subChain;
    }
}
