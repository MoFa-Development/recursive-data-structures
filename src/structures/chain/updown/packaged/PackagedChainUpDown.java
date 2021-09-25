package structures.chain.updown.packaged;

import java.util.Iterator;

import exceptions.ChainIndexOutOfBoundsException;
import structures.chain.Chain;
import structures.chain.ChainElement;
import structures.chain.down.ChainDownElement;
import structures.chain.updown.ChainUpDown;
import structures.chain.updown.ChainUpDownElement;
import structures.chain.util.ChainDownIterator;


public class PackagedChainUpDown<E> extends Chain<E>
{
    private static final int DEFAULT_PACKAGE_SIZE = 2;
    
    protected ChainUpDown<PackageUpDown<E>> packages;
    private int packageSize;

    public PackagedChainUpDown() {
        this.packages = new ChainUpDown<>();
        this.packageSize = DEFAULT_PACKAGE_SIZE;
    }

    public PackagedChainUpDown(int packageSize) {
        this.packages = new ChainUpDown<>();
        this.packageSize = packageSize;
    }

    @Override
    public boolean add(E obj)
    {
        if(packages.getLast() == null || packages.getLast().size() >= packageSize) {
            ChainUpDownElement<E> elem = new ChainUpDownElement<>(obj);
            
            elem.setPrev((ChainUpDownElement<E>) getLastElement());
            
            ChainUpDownElement<E> lastElem = (ChainUpDownElement<E>) getLastElement();
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
    public boolean add(E obj, int index) throws ChainIndexOutOfBoundsException
    {
        // TODO implement
        return false;
    }

    @Override
    public void clear()
    {
        packages.clear();
    }

    @Override
    public E get(int index) throws ChainIndexOutOfBoundsException
    {
        ChainUpDownElement<E> elem = (ChainUpDownElement<E>) getElement(index);

        if(elem == null) {
            throw indexOutOfBounds(index);
        }

        return elem.get();
    }

    protected PackageUpDown<E> getFirstPackage() {
        return this.packages.getFirst();
    }

    protected PackageUpDown<E> getLastPackage() {
        return this.packages.getLast();
    }

    @Override
    public E getFirst() {
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
    public ChainElement<E> getFirstElement() {
        PackageUpDown<E> firstPackage = getFirstPackage();
        
        if(firstPackage == null) {
            return null;
        }

        return firstPackage.getFirstElement();
    }

    @Override
    public ChainElement<E> getLastElement() {
        PackageUpDown<E> lastPackage = getLastPackage();
        
        if(lastPackage == null) {
            return null;
        }

        return lastPackage.getLastElement();
    }

    @Override
    public void setFirstElement(ChainElement<E> firstElement) {
        this.getFirstPackage().setFirstElement(firstElement);
    }

    @Override
    public void setLastElement(ChainElement<E> lastElement) {
        this.getLastPackage().setLastElement(lastElement);        
    }

    @Override
    public Iterator<E> iterator()
    {
        return new ChainDownIterator<>((ChainDownElement<E>) getFirstPackage().getFirstElement());
    }

    @Override
    public boolean remove(int index) throws ChainIndexOutOfBoundsException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected ChainElement<E> getElement(int index) {
        int i = 0;

        for(PackageUpDown<E> pkg: packages) {
            if(i + pkg.size() > index) {
                return pkg.getElement(index-i);
            }
            
            i+= pkg.size();
        }

        return null;
    }
}
