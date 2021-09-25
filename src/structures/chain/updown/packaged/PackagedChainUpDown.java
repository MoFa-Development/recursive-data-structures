package structures.chain.updown.packaged;

import java.util.List;

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
        // TODO implement
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
    public ChainElement<E> getFirstElem() {
        PackageUpDown<E> firstPackage = getFirstPackage();
        
        if(firstPackage == null) {
            return null;
        }

        return firstPackage.getFirstElem();
    }

    @Override
    public ChainElement<E> getLastElem() {
        PackageUpDown<E> lastPackage = getLastPackage();
        
        if(lastPackage == null) {
            return null;
        }

        return lastPackage.getLastElem();
    }

    @Override
    public void setFirstElem(ChainElement<E> firstElement) {
        this.getFirstPackage().setFirstElem(firstElement);
    }

    @Override
    public void setLastElem(ChainElement<E> lastElement) {
        this.getLastPackage().setLastElem(lastElement);        
    }

    @Override
    public ChainDownIterator<E> listIterator()
    {
        return new ChainDownIterator<>(this, (ChainDownElement<E>) getFirstPackage().getFirstElem());
    }

    @Override
    public E remove(int index) throws ChainIndexOutOfBoundsException
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected ChainElement<E> getElem(int index) {
        int i = 0;

        for(PackageUpDown<E> pkg: packages) {
            if(i + pkg.size() > index) {
                return pkg.getElem(index-i);
            }
            
            i+= pkg.size();
        }

        return null;
    }

    @Override
    public E set(int arg0, E arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }
}
