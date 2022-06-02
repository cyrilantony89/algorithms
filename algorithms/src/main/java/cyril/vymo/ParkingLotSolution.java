package cyril.vymo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import cyril.vymo.ParkingLotSolution.TicketNumGenerator;

public class ParkingLotSolution {

	public static class TicketNumGenerator {

		public int getTicketNum() {

			return 1;

		}

	}

	/**
	 * Multi level Parking lot 1. Create an automated ticketing system that allows
	 * the use of parking lot 2. A parking lot can hold up to 'n' cars(only cars) at
	 * any given point in time 3. Each slot is given a number starting at 1
	 * increasing with increasing distance from the entry point & level in steps of
	 * one 4. When a car enters the parking lot, a ticket is issued to the driver 5.
	 * The ticket issuing process includes documenting the registration number and
	 * the color of the car and allocating an available parking slot to the car
	 * before actually handing over a ticket to the driver 6. The customer should be
	 * allocated a parking slot which is nearest to the entry 7. At the exit the
	 * customer returns the ticket which then marks the slot they were using as
	 * being available 8. At any time, the ticketing system should be able to
	 * provide 1. Registration numbers of all cars of a particular colour 2. Slot
	 * number in which a car with a given registration number is parked 3. Slot
	 * numbers of all slots where a car of a particular colour is parked
	 * 
	 * 
	 * 
	 * Classes & Interfaces
	 * 
	 * 
	 * @author cantony
	 *
	 */

	static TicketNumGenerator ticketNumGenerator = new TicketNumGenerator();

	interface Vehicle {
		String getRegNum();

		String getColor();
	}

	class Car implements Vehicle {
		String regNum;
		String color;

		@Override
		public String getRegNum() {
			return regNum;
		}

		@Override
		public String getColor() {
			return color;
		}
	}

	class Ticket {
		Ticket(int ticketNum, Vehicle vehicle, Slot slot) {
			this.ticketId = ticketNum;
			this.vehicle = vehicle;
			this.slot = slot;
		}

		int ticketId;
		Vehicle vehicle;
		Slot slot;

	}

	class Slot {
		Slot(int order) {
			this.order = order;
		}

		Vehicle vehicle;
		boolean isAvailable;
		int order;
	}

	class Floor{
		Set<Slot> slots;
	}
	class ParkingLot {
		
		Set<Floor> floors;
		
		
		Set<Slot> slots;

		ParkingLot(int size) {
			slots = new TreeSet<>(new Comparator<Slot>() {

				@Override
				public int compare(Slot o1, Slot o2) {
					return o1.order - o2.order;
				}
			});
			for (int i = 0; i < size - 1; i++) {
				Slot slot = new Slot(i + 1);
				slots.add(slot);

			}

			this.size = size;
		}

		int size;

		Ticket issueTicket(Vehicle vehicle) {

			for (Slot slot : slots) {
				if (slot.isAvailable) {
					int ticketNum = ticketNumGenerator.getTicketNum();
					slot.isAvailable = false;
					slot.vehicle = vehicle;
					return new Ticket(ticketNum, vehicle, slot);

				}

			}

			return null;
		}

		void exitParkingLot(Ticket ticket) {

			Slot slot1 = ticket.slot;

			for (Slot slot : slots) {
				if (slot.equals(slot1)) {
					slot.vehicle = null;
					slot.isAvailable = true;

				}
			}

		}

		List<String> getRegNumbersOfColor(String color) {

			List<String> res = new ArrayList<>();
			for (Slot slot : slots) {
				if (!slot.isAvailable) {
					Vehicle vehicle = slot.vehicle;
					if (vehicle.getColor().equals(color)) {
						res.add(vehicle.getRegNum());
					}

				}

			}
			return res;
		}

		int getSlotOfCarWithRegNum(String regNum) {

			for (Slot slot : slots) {
				if (!slot.isAvailable) {
					Vehicle vehicle = slot.vehicle;
					if (vehicle.getRegNum().equals(regNum)) {
						return slot.order;
					}

				}

			}
			return -1;
		}

		List<Integer> getListOfSlotNumForColor(String color) {

			List<Integer> res = new ArrayList<>();
			for (Slot slot : slots) {
				if (!slot.isAvailable) {
					Vehicle vehicle = slot.vehicle;
					if (vehicle.getColor().equals(color)) {
						res.add(slot.order);
					}

				}

			}
			return res;
		}

	}

}
