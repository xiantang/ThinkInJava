package JavaConcurrency.AvoidingLivenessHazards;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 14:01
 */
public class CooperatingNoDeadlock {
    class Taxi {
        private final Dispatcher dispatcher;
        private Point location, destination;
        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }

        public Dispatcher getDispatcher() {
            return dispatcher;
        }

        public Point getLocation() {
            return location;
        }

        public synchronized void setLocation(Point location) {
            boolean reachedDestination;
            // 使用同步代码块 锁住当前对象
            synchronized (this) {
                this.location = location;
                reachedDestination = location.equals(destination);
            }
            if (reachedDestination) {
                dispatcher.notifyAvailable(this);
            }
        }

    }

    class Dispatcher {
        private final Set<Taxi> taxis;
        private final Set<Taxi> availableTaxis;

        public Dispatcher() {
            taxis = new HashSet<Taxi>();
            availableTaxis = new HashSet<Taxi>();
        }

        public synchronized void notifyAvailable(Taxi taxi) {
            availableTaxis.add(taxi);
        }

        public Image getImage() {
            Set<Taxi> copy;
            synchronized (this) {
                copy = new HashSet<Taxi>(taxis);
            }
            Image image = new Image() {
                @Override
                public int getWidth(ImageObserver observer) {
                    return 0;
                }

                @Override
                public int getHeight(ImageObserver observer) {
                    return 0;
                }

                @Override
                public ImageProducer getSource() {
                    return null;
                }

                @Override
                public Graphics getGraphics() {
                    return null;
                }

                @Override
                public Object getProperty(String name, ImageObserver observer) {
                    return null;
                }
            };

            for (Taxi t :
                    copy) {
//                image.drawMarker(t.getLocation());
            }
            return image;
        }

    }
}
