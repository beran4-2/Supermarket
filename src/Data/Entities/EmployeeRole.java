package Data.Entities;

/**
 * Defines the specific roles that an employee can be assigned to.
 *
 * RESTOCKER Employee moves products from storage to shelves.
 *
 * ORDERER Employee monitors stock levels and orders missing products.
 */
public enum EmployeeRole {
    RESTOCKER, ORDERER
}
